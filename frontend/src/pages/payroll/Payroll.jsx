import React, { useState } from "react";
import { FiSearch, FiDownloadCloud } from "react-icons/fi";
import PayrollTable from "../../components/payroll/PayrollTable";

const Payroll = () => {
  const [searchTerm, setSearchTerm] = useState("");

  return (
    <div className="space-y-6">
      {/* Header Area */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4">
        <div>
          <h1 className="text-3xl font-extrabold text-gray-900">Payroll</h1>
          <p className="text-sm text-gray-400 mt-1">
            Manage employee salaries, bonuses, and deductions.
          </p>
        </div>

        <div className="flex items-center gap-4 w-full md:w-auto">
          {/* Search Input */}
          <div className="relative flex-1 md:w-64">
            <input
              type="text"
              placeholder="Search employee"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              className="w-full pl-4 pr-10 py-2.5 rounded-full border border-gray-200 focus:outline-none focus:ring-2 focus:ring-brand-green/20 focus:border-brand-green transition-all shadow-sm"
            />
            <FiSearch className="absolute right-4 top-1/2 -translate-y-1/2 text-gray-400" />
          </div>

          <button className="flex items-center gap-2 px-5 py-2.5 bg-slate-900 text-white rounded-full font-medium hover:bg-slate-800 transition-colors shadow-sm">
            <FiDownloadCloud />
            Export CSV
          </button>
        </div>
      </div>

      {/* Tabs */}
      <div className="flex items-center gap-8 border-b border-gray-200">
        <button className="pb-4 font-semibold text-brand-green border-b-2 border-brand-green relative top-[1px]">
          All Employees
        </button>
        <button className="pb-4 font-medium text-gray-500 hover:text-gray-900 transition-colors">
          Pending
        </button>
        <button className="pb-4 font-medium text-gray-500 hover:text-gray-900 transition-colors">
          Processed
        </button>
      </div>

      {/* Table Content */}
      <div className="card p-0 overflow-hidden">
        <PayrollTable searchTerm={searchTerm} />
      </div>
    </div>
  );
};

export default Payroll;
