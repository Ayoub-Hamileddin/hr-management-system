import React from "react";
import AppRouter from "./router/AppRouter";
import { Toaster } from "sonner";

const App = () => {
  return (
    <>
      <Toaster position="top-right" richColors closeButton    />
      <main>
        <AppRouter />
      </main>
    </>
  );
};

export default App;
