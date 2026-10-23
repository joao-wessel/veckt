import { DOCUMENT } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable, inject, signal } from '@angular/core';
import { ApiResponse, AuthResponse, AuthScope } from '../auth/auth.models';

export type ColorPalette = 'vectk' | 'terracotta' | 'indigo';
export type ThemeMode = 'light' | 'dark';

const THEME_STORAGE_KEY = 'vectk.theme';
const PALETTE_STORAGE_KEY = 'vectk.palette';
const API_URL = '/api';

interface AppearancePreferences {
  themeMode: ThemeMode;
  colorPalette: ColorPalette;
}

const THEME_COLORS: Record<ColorPalette, string> = {
  vectk: '#5B7F86',
  terracotta: '#b0522f',
  indigo: '#524aae'
};

@Injectable({ providedIn: 'root' })
export class ThemeService {
  private readonly document = inject(DOCUMENT);
  private readonly http = inject(HttpClient);

  readonly mode = signal<ThemeMode>(this.readStoredMode());
  readonly palette = signal<ColorPalette>(this.readStoredPalette());

  constructor() {
    this.apply();
  }

  toggleMode() {
    this.mode.update((current) => current === 'dark' ? 'light' : 'dark');
    this.persist();
  }

  setPalette(palette: ColorPalette) {
    this.palette.set(palette);
    this.persist();
  }

  applyUserPreferences(user: AuthResponse | null) {
    if (!user) return;
    this.mode.set(user.themeMode || 'light');
    this.palette.set(user.colorPalette || 'vectk');
    this.apply();
    this.persistLocal();
  }

  refreshFromServer(scope: AuthScope) {
    this.http.get<ApiResponse<AppearancePreferences>>(`${API_URL}/${scope}/me/preferences`).subscribe({
      next: (response) => {
        this.mode.set(response.data.themeMode);
        this.palette.set(response.data.colorPalette);
        this.apply();
        this.persistLocal();
        this.updateStoredUser(response.data);
      }
    });
  }

  private apply() {
    const root = this.document.documentElement;
    root.classList.toggle('dark', this.mode() === 'dark');
    root.dataset['palette'] = this.palette();
    this.applyFavicon();
    this.applyThemeColor();
  }

  private persist() {
    this.apply();
    this.persistLocal();
    this.saveRemote();
  }

  private persistLocal() {
    localStorage.setItem(THEME_STORAGE_KEY, this.mode());
    localStorage.setItem(PALETTE_STORAGE_KEY, this.palette());
  }

  private saveRemote() {
    const token = localStorage.getItem('vectk.token');
    const scope = localStorage.getItem('vectk.scope') as AuthScope | null;
    if (!token || !scope) return;

    const preferences = { themeMode: this.mode(), colorPalette: this.palette() };
    this.updateStoredUser(preferences);
    this.http.put<ApiResponse<AppearancePreferences>>(`${API_URL}/${scope}/me/preferences`, preferences).subscribe({
      next: (response) => this.updateStoredUser(response.data)
    });
  }

  private updateStoredUser(preferences: AppearancePreferences) {
    const raw = localStorage.getItem('vectk.user');
    if (!raw) return;
    const user = JSON.parse(raw) as AuthResponse;
    localStorage.setItem('vectk.user', JSON.stringify({
      ...user,
      themeMode: preferences.themeMode,
      colorPalette: preferences.colorPalette
    }));
  }

  private applyFavicon() {
    let favicon = this.document.querySelector<HTMLLinkElement>('link[rel="icon"]');
    if (!favicon) {
      favicon = this.document.createElement('link');
      favicon.rel = 'icon';
      this.document.head.appendChild(favicon);
    }
    favicon.type = 'image/svg+xml';
    favicon.href = this.mode() === 'dark'
      ? 'assets/brand/vectk-favicon-light.svg?v=2'
      : 'assets/brand/vectk-favicon.svg?v=2';
  }

  private applyThemeColor() {
    const color = THEME_COLORS[this.palette()];
    let meta = this.document.querySelector<HTMLMetaElement>('meta[name="theme-color"]');
    if (!meta) {
      meta = this.document.createElement('meta');
      meta.name = 'theme-color';
      this.document.head.appendChild(meta);
    }
    meta.content = this.mode() === 'dark' ? '#0b0b0c' : color;
  }

  private readStoredMode(): ThemeMode {
    return localStorage.getItem(THEME_STORAGE_KEY) === 'dark' ? 'dark' : 'light';
  }

  private readStoredPalette(): ColorPalette {
    const palette = localStorage.getItem(PALETTE_STORAGE_KEY);
    return palette === 'terracotta' || palette === 'indigo' ? palette : 'vectk';
  }
}
