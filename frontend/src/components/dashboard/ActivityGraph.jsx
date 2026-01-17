import React from "react";
import {
  CartesianGrid,
  Legend,
  Line,
  LineChart,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";
import TeamGraph from "./TeamGraph";
import { FiCalendar } from "react-icons/fi";

const ActivityGraph = () => {
  const data = [
    {
      name: "Page A",
      uv: 4000,
      pv: 2400,
      amt: 2400,
    },
    {
      name: "Page B",
      uv: 3000,
      pv: 1398,
      amt: 2210,
    },
    {
      name: "Page C",
      uv: 2000,
      pv: 9800,
      amt: 2290,
    },
    {
      name: "Page D",
      uv: 2780,
      pv: 3908,
      amt: 2000,
    },
    {
      name: "Page E",
      uv: 1890,
      pv: 4800,
      amt: 2181,
    },
    {
      name: "Page F",
      uv: 2390,
      pv: 3800,
      amt: 2500,
    },
    {
      name: "Page G",
      uv: 3490,
      pv: 4300,
      amt: 2100,
    },
  ];

  return (
<<<<<<< Updated upstream
    <div className="col-span-8 border border-stone-300 overflow-hidden rounded ">
      <div className="p-4">
        <h3 className="flex items-center gap-1.5 font-medium">
          <FiUser /> activity
        </h3>
=======
    <div className="px-2 ">
      <div className="flex justify-between items-center my-2 mx-9">
        <div>
          <h3 className="font-semibold text-2xl mb-4">Team Performance</h3>
          <div className="flex items-center space-x-3 mb-4">
            <TeamGraph name={"Product Team"} color={"bg-[#F5C754]"} />
            <TeamGraph name={"Project Team"} color={"bg-[#29A071]"} />
          </div>
        </div>
        <button className="flex  items-center gap-1 p-2.5 font-medium  border border-gray-300 rounded-lg shadow-md">
          Last 7 month
          <FiCalendar />
        </button>
>>>>>>> Stashed changes
      </div>
      {/*  // TODO: our graph  */}
      <LineChart
        style={{
          width: "100%",
          maxWidth: "100%",
          maxHeight: "40vh",
          aspectRatio: 1.618,
        }}
        responsive
        data={data}
      >
<<<<<<< Updated upstream
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="name" padding={{ left: 30, right: 30 }} />
        <YAxis width="auto" />
        <Tooltip />
        <Legend />
=======
        <CartesianGrid />
        <XAxis dataKey="name" padding={{ left: 30, right: 30 }} />
        <YAxis width="auto" />
        <Tooltip />
>>>>>>> Stashed changes
        <Line
          type="monotone"
          dataKey="pv"
          stroke="#8884d8"
          activeDot={{ r: 8 }}
        />
        <Line type="monotone" dataKey="uv" stroke="#82ca9d" />
      </LineChart>
    </div>
  );
};

export default ActivityGraph;
