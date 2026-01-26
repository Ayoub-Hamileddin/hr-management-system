import React from "react";

const MetricsOverview = ({ color, label, value }) => {
  return (
    <div className="flex justify-between items-center mt-5">
      <div className="flex items-center gap-2 ">
        <span className={` ${color}  size-2.5 rounded-full`}></span>
        <p className="text-sm font-semibold text-stone-600">{label}</p>
      </div>
      <p className="font-semibold   ">{value}</p>
    </div>
  );
};

export default MetricsOverview;
