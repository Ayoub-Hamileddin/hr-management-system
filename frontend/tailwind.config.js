/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
    ".flowbite-react\\class-list.json",
  ],
  theme: {
    extend: {
      colors: {
        brand: {
          DEFAULT: "#0cad5d",
          50: "#f0fdf6",
          100: "#dcfce9",
          200: "#bbf7d4",
          300: "#86efb0",
          400: "#4ade80",
          500: "#0cad5d",
          600: "#09954f",
          700: "#077a41",
          800: "#065e33",
          900: "#044827",
        },
        accent: {
          DEFAULT: "#F5C754",
          light: "#FEF3C7",
        },
        primary: {
          50: "#eff6ff",
          100: "#dbeafe",
          200: "#bfdbfe",
          300: "#93c5fd",
          400: "#60a5fa",
          500: "#3b82f6",
          600: "#2563eb",
          700: "#1d4ed8",
          800: "#1e40af",
          900: "#1e3a8a",
          950: "#172554",
        },
      },
      fontFamily: {
        sans: ["Manrope", "Inter", "ui-sans-serif", "system-ui", "sans-serif"],
        body: ["Manrope", "Inter", "ui-sans-serif", "system-ui", "sans-serif"],
        manrope: ["Manrope", "sans-serif"],
      },
      borderRadius: {
        base: "0.75rem",
      },
      boxShadow: {
        card: "0 2px 8px 0 rgba(0,0,0,0.06)",
        "card-lg": "0 4px 24px 0 rgba(0,0,0,0.10)",
      },
    },
  },
};
