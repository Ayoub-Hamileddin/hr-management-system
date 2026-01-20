import React from "react";
import { FiTrendingDown, FiTrendingUp } from "react-icons/fi";

const StatCard = ({ value, title, Icon, percentage, trend }) => {
  return (
    <div className=" bg-white p-8">
      <div className="bg-stone-100 size-[50px] flex items-center justify-center rounded-full ">
        <Icon className={"size-5 hover:text-[#0cad5d] cursor-pointer"} />
      </div>
      <div className="flex items-center gap-4 mt-2">
        <p className="text-2xl font-semibold">{value}</p>
        <span
          className={`${trend === "up" ? " bg-green-100 text-green-700 " : " bg-red-100 text-red-700 "} flex items-center gap-1.5 rounded-full px-3 py-0.5`}
        >
          {trend === "up" ? <FiTrendingUp /> : <FiTrendingDown />}{" "}
          <span className="font-sans text-sm">{percentage}</span>{" "}
        </span>
      </div>
      <p className="mt-4 text-lg font-semibold text-slate-500">{title}</p>
    </div>
  );
};

export default StatCard;
