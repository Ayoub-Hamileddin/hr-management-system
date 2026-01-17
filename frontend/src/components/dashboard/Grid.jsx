import React from "react";
import StatCard from "./StatCard";
import { FiUsers } from "react-icons/fi";
import { IoBriefcaseSharp } from "react-icons/io5";
import { FaMinus, FaPlus } from "react-icons/fa";
import ActivityGraph from "./ActivityGraph";

const Grid = () => {
  return (
    <div className="p-8 bg-slate-50 h-[100%]">
      <header className="">
        <h1 className="text-3xl font-semibold">Hi, Pristia</h1>
        <p className="mt-2 text-stone-500 font-light">
          this is your HR dashboard report
        </p>
      </header>

      <div className="grid grid-cols-12 ">
        <div className="col-span-5 grid grid-cols-2 gap-0.5">
          <StatCard
            title="Total Employees"
            value="3,540"
            percentage={25.5}
            Icon={FiUsers}
          />
          <StatCard
            title="Job Applicants"
            value="1,150"
            percentage={4.1}
            Icon={IoBriefcaseSharp}
          />
          <StatCard
            title="New Employees"
            value="500"
            percentage={5.1}
            Icon={FaPlus}
          />
          <StatCard
            title="Resigned Employees"

            value={"93"}
            percentage={"-25.5 %"}
            trend="down"
            Icon={FaMinus}
          />
        </div>
        <div className="col-span-7 bg-white">
          <ActivityGraph />
        </div>
      </div>;
    </div>
  );
};

export default Grid;
