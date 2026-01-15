import React from "react";
import { FiUser } from "react-icons/fi";
import {
  CartesianGrid,
  Legend,
  Line,
  LineChart,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";

const ActivityGraph = () => {
  const data = [
    {
      name: "Page A",
      uv: 4000,
      pv: 700,
      amt: 2400,
    },
    {
      name: "Page B",
      uv: 4000,
      pv: 9000,
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
    <div className=" ">
      <h3 className="">Team Performance</h3>
      {/*  // TODO: our graph  */}
      <LineChart
        style={{
          width: "100%",
          maxWidth: "700px",
          maxHeight: "70vh",
          aspectRatio: 1.618,
        }}
        responsive
        data={data}
      >
        {/* <CartesianGrid /> */}
        <XAxis dataKey="name" padding={{ left: 30, right: 30 }} />
        <YAxis width="auto" />
        {/* <Tooltip /> */}
        {/* <Legend /> */}
        <Line
          type="monotone"
          dataKey="pv"
          stroke="#F5C754"
          activeDot={{ r: 8 }}
        />
        <Line type="monotone" dataKey="uv" stroke="#29A071" />
      </LineChart>
    </div>
  );
};

export default ActivityGraph;
