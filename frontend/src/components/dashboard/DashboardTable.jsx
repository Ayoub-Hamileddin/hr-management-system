import React from "react";
import { FiArrowRight } from "react-icons/fi";
import { Link } from "react-router-dom";

const recentEmployees = [
  { id: 1, name: "Sarah Johnson", position: "Product Designer", department: "Design", hireDate: "Apr 15, 2025", status: "ACTIVE", avatar: null },
  { id: 2, name: "Mohamed Ali", position: "Backend Engineer", department: "Engineering", hireDate: "Apr 10, 2025", status: "ACTIVE", avatar: null },
  { id: 3, name: "Emily Chen", position: "Marketing Lead", department: "Marketing", hireDate: "Mar 28, 2025", status: "ACTIVE", avatar: null },
  { id: 4, name: "Carlos Rivera", position: "HR Specialist", department: "HR", hireDate: "Mar 20, 2025", status: "INACTIVE", avatar: null },
  { id: 5, name: "Fatima Zahra", position: "Finance Analyst", department: "Finance", hireDate: "Mar 10, 2025", status: "ACTIVE", avatar: null },
];

const getInitials = (name) =>
  name.split(" ").map((n) => n[0]).join("").toUpperCase().slice(0, 2);

const avatarColors = [
  "bg-brand text-white",
  "bg-accent text-gray-900",
  "bg-indigo-100 text-indigo-600",
  "bg-pink-100 text-pink-600",
  "bg-orange-100 text-orange-600",
];

const DashboardTable = () => {
  return (
    <div className="card">
      <div className="flex items-center justify-between mb-5">
        <div>
          <h3 className="text-lg font-bold text-gray-900">Recent Employees</h3>
          <p className="text-sm text-gray-400 mt-0.5">Latest hires this month</p>
        </div>
        <Link
          to="/dashboard/employees"
          className="flex items-center gap-1.5 text-xs font-semibold text-brand hover:underline"
        >
          View all <FiArrowRight size={14} />
        </Link>
      </div>

      <div className="overflow-x-auto">
        <table className="w-full">
          <thead>
            <tr className="border-b border-gray-100">
              <th className="text-left text-xs font-semibold text-gray-400 pb-3 pr-4">Employee</th>
              <th className="text-left text-xs font-semibold text-gray-400 pb-3 pr-4">Position</th>
              <th className="text-left text-xs font-semibold text-gray-400 pb-3 pr-4">Department</th>
              <th className="text-left text-xs font-semibold text-gray-400 pb-3 pr-4">Hire Date</th>
              <th className="text-left text-xs font-semibold text-gray-400 pb-3">Status</th>
            </tr>
          </thead>
          <tbody>
            {recentEmployees.map((emp, idx) => (
              <tr key={emp.id} className="border-b border-gray-50 hover:bg-gray-50/50 transition-colors">
                <td className="py-3 pr-4">
                  <div className="flex items-center gap-3">
                    <div
                      className={`w-9 h-9 rounded-full flex items-center justify-center text-xs font-bold shrink-0 ${avatarColors[idx % avatarColors.length]}`}
                    >
                      {getInitials(emp.name)}
                    </div>
                    <span className="text-sm font-semibold text-gray-900">{emp.name}</span>
                  </div>
                </td>
                <td className="py-3 pr-4 text-sm text-gray-600">{emp.position}</td>
                <td className="py-3 pr-4 text-sm text-gray-600">{emp.department}</td>
                <td className="py-3 pr-4 text-sm text-gray-500">{emp.hireDate}</td>
                <td className="py-3">
                  <span
                    className={
                      emp.status === "ACTIVE" ? "badge-active" : "badge-inactive"
                    }
                  >
                    <span className={`w-1.5 h-1.5 rounded-full ${emp.status === "ACTIVE" ? "bg-green-500" : "bg-gray-400"}`} />
                    {emp.status === "ACTIVE" ? "Active" : "Inactive"}
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default DashboardTable;
