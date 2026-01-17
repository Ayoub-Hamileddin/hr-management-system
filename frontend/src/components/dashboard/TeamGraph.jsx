import React from "react";

const TeamGraph = ({ name, color }) => {
  console.log(`bg-${color}-600  `);

  return (
    <div className="flex items-center gap-2 ">
      <span className={` ${color}  size-2.5 rounded-full`}></span>
      <p className="text-sm font-semibold text-stone-600">{name}</p>
    </div>
  );
};

export default TeamGraph;
