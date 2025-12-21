import React from "react";

const Plan = () => {
  return (
    <div
      className="flex sticky top-[calc(100vh-48px-40px)]  flex-col h-12 border-t px-2  
        justify-end text-xs
    "
    >
      <div className="flex items-center justify-between">
        <div>
          <p className="font-bold">Entreprise</p>
          <p className="text-stone-500">as you go</p>
        </div>
        <button className="px-2 py-1.5 font-semibold bg-stone-200 hover:bg-stone-200 transition-colors rounded ">
          Support
        </button>
      </div>
    </div>
  );
};

export default Plan;
