module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        vectk: {
          50: "rgb(var(--vectk-50) / <alpha-value>)",
          100: "rgb(var(--vectk-100) / <alpha-value>)",
          200: "rgb(var(--vectk-200) / <alpha-value>)",
          500: "rgb(var(--vectk-500) / <alpha-value>)",
          600: "rgb(var(--vectk-600) / <alpha-value>)",
          700: "rgb(var(--vectk-700) / <alpha-value>)",
          900: "rgb(var(--vectk-900) / <alpha-value>)"
        }
      },
      boxShadow: {
        soft: "0 18px 60px rgba(15, 23, 42, 0.08)"
      }
    }
  },
  plugins: []
};
