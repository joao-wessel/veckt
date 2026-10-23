import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-logo',
  standalone: true,
  template: `
    <div class="brand-logo" [class.brand-logo-compact]="compact">
      @if (compact) {
        <img class="brand-logo-default" src="assets/brand/veckt-logo-simple.svg" alt="Veckt">
        <img class="brand-logo-dark" src="assets/brand/veckt-logo-simple-light.svg" alt="Veckt">
      } @else if (sidebar) {
        <img class="brand-logo-default" src="assets/brand/veckt-logo-full.svg" alt="Veckt">
        <img class="brand-logo-dark" src="assets/brand/veckt-logo-full-light.svg" alt="Veckt">
      } @else {
        <img class="brand-logo-default" src="assets/brand/veckt-logo-full.svg" alt="Veckt">
        <img class="brand-logo-dark" src="assets/brand/veckt-logo-full-light.svg" alt="Veckt">
      }
    </div>
  `,
  styles: [`
    .brand-logo { display: flex; align-items: center; width: var(--veckt-logo-width, 13.75rem); max-width: 100%; }
    .brand-logo-compact { width: var(--veckt-logo-width, 4.5rem); }
    img { display: block; width: 100%; height: auto; }
    .brand-logo-dark { display: none; }
    :host-context(.dark) .brand-logo-default { display: none; }
    :host-context(.dark) .brand-logo-dark { display: block; }
  `]
})
export class LogoComponent {
  @Input() compact = false;
  @Input() sidebar = false;
}
