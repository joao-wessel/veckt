module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        veckt: {
          50: "rgb(var(--veckt-50) / <alpha-value>)",
          100: "rgb(var(--veckt-100) / <alpha-value>)",
          200: "rgb(var(--veckt-200) / <alpha-value>)",
          500: "rgb(var(--veckt-500) / <alpha-value>)",
          600: "rgb(var(--veckt-600) / <alpha-value>)",
          700: "rgb(var(--veckt-700) / <alpha-value>)",
          900: "rgb(var(--veckt-900) / <alpha-value>)"
        }
      },
      boxShadow: {
        soft: "0 18px 60px rgba(15, 23, 42, 0.08)"
      }
    }
  },
  plugins: []
};
