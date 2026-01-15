import React from "react";

const IconBadge = ({ children }) => {
  return (
    <div className="relative inline-block cursor-pointer">
      {children}
      <span className="absolute size-2 top-0 right-0 bg-red-500 rounded-full ring-2 ring-white "></span>
    </div>
  );
};

export default IconBadge;
