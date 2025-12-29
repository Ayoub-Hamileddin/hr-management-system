import React from "react";
import StartCard from "./StartCard";
import ActivityGraph from "./ActivityGraph";
import UsageRadar from "./UsageRadar";

const Grid = () => {
  return (
    <div className="px-4 grid gap-3 grid-cols-12 ">
      <StartCard />
      <ActivityGraph />
      <UsageRadar />
    </div>
  );
};

export default Grid;
