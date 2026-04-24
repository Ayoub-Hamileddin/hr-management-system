import React, { useState } from "react";
import { FiSearch, FiGrid, FiList, FiClock, FiChevronDown } from "react-icons/fi";
import RecruitmentTable from "../../components/recruitment/RecruitmentTable";

const Recruitment = () => {
  const [searchTerm, setSearchTerm] = useState("");

  return (
    <div className="space-y-6">
      {/* Header Area */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4">
        <div>
          <h1 className="text-3xl font-extrabold text-gray-900">Recruitment</h1>
          <div className="flex items-center text-sm font-medium text-gray-500 mt-1">
            <span className="hover:text-gray-900 cursor-pointer transition-colors">List Job</span>
            <span className="mx-2">&gt;</span>
            <span className="text-gray-900">3D Designer</span>
          </div>
        </div>

        <div className="flex items-center gap-4 w-full md:w-auto">
          {/* Search Input */}
          <div className="relative flex-1 md:w-64">
            <input
              type="text"
              placeholder="Search what you need"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              className="w-full pl-4 pr-10 py-2.5 rounded-full border border-gray-200 focus:outline-none focus:ring-2 focus:ring-brand-green/20 focus:border-brand-green transition-all shadow-sm"
            />
            <FiSearch className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400" />
          </div>

          {/* Add Candidates Button */}
          <button className="flex items-center gap-2 px-5 py-2.5 bg-slate-900 text-white rounded-full font-medium hover:bg-slate-800 transition-colors shadow-sm">
            Add Candidates
            <FiChevronDown />
          </button>

          {/* View Toggles */}
          <div className="flex items-center gap-2 ml-2">
            <button className="p-2.5 bg-brand-green text-white rounded-full shadow-sm hover:bg-brand-green/90 transition-colors">
              <FiGrid size={18} />
            </button>
            <button className="p-2.5 bg-white text-gray-500 rounded-full shadow-sm border border-gray-100 hover:bg-gray-50 transition-colors">
              <FiList size={18} />
            </button>
            <button className="p-2.5 bg-white text-gray-500 rounded-full shadow-sm border border-gray-100 hover:bg-gray-50 transition-colors">
              <FiClock size={18} />
            </button>
          </div>
        </div>
      </div>

      {/* Tabs */}
      <div className="flex items-center gap-8 border-b border-gray-200">
        <button className="pb-4 font-semibold text-brand-green border-b-2 border-brand-green relative top-[1px]">
          Documents
        </button>
        <button className="pb-4 font-medium text-gray-500 hover:text-gray-900 transition-colors">
          News
        </button>
        <button className="pb-4 font-medium text-gray-500 hover:text-gray-900 transition-colors">
          Payslip
        </button>
        <button className="pb-4 font-medium text-gray-500 hover:text-gray-900 transition-colors">
          Report
        </button>
      </div>

      {/* Table Content */}
      <div className="card p-0 overflow-hidden">
        <RecruitmentTable searchTerm={searchTerm} />
      </div>
    </div>
  );
};

export default Recruitment;
