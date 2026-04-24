import React from "react";
import { format } from "date-fns";
import { useGetAllPayrollsQuery, useUpdatePayrollStatusMutation } from "../../features/payroll/payrollApi";
import { FiCheckCircle } from "react-icons/fi";

const statusToDisplay = {
  "PENDING": "Pending",
  "PROCESSED": "Processed",
  "PAID": "Paid"
};

const PayrollTable = ({ searchTerm }) => {
  const { data: payrolls = [], isLoading, isError } = useGetAllPayrollsQuery();
  const [updateStatus] = useUpdatePayrollStatusMutation();

  const filteredPayrolls = payrolls.filter((p) => {
    const fullName = (p.employeeName || "").toLowerCase();
    return fullName.includes((searchTerm || "").toLowerCase());
  });

  const handleUpdateStatus = async (id, newStatus) => {
    try {
      await updateStatus({ id, status: newStatus }).unwrap();
    } catch (err) {
      console.error("Failed to update status", err);
    }
  };

  const getStatusBadge = (status) => {
    switch (status) {
      case "PAID":
        return <span className="px-3 py-1 bg-green-100 text-green-700 rounded-full text-xs font-semibold">Paid</span>;
      case "PROCESSED":
        return <span className="px-3 py-1 bg-blue-100 text-blue-700 rounded-full text-xs font-semibold">Processed</span>;
      default:
        return <span className="px-3 py-1 bg-yellow-100 text-yellow-700 rounded-full text-xs font-semibold">Pending</span>;
    }
  };

  if (isLoading) return <div className="p-8 text-center text-gray-500">Loading payroll data...</div>;
  if (isError) return <div className="p-8 text-center text-red-500">Failed to load payroll data.</div>;

  return (
    <div className="overflow-x-auto">
      <table className="w-full text-left border-collapse">
        <thead>
          <tr className="border-b border-gray-200 text-sm font-medium text-gray-500">
            <th className="pb-4 pt-4 pl-6 font-semibold">Employee</th>
            <th className="pb-4 pt-4 font-semibold">Period</th>
            <th className="pb-4 pt-4 font-semibold">Base Salary</th>
            <th className="pb-4 pt-4 font-semibold text-green-600">+ Bonus</th>
            <th className="pb-4 pt-4 font-semibold text-red-500">- Deduction</th>
            <th className="pb-4 pt-4 font-semibold">Net Pay</th>
            <th className="pb-4 pt-4 font-semibold">Status</th>
            <th className="pb-4 pt-4 pr-6 font-semibold text-right">Action</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {filteredPayrolls.length > 0 ? (
            filteredPayrolls.map((p) => (
              <tr key={p.id} className="border-b border-gray-100 hover:bg-gray-50 transition-colors">
                <td className="py-4 pl-6 font-semibold text-gray-900">{p.employeeName}</td>
                <td className="py-4 text-gray-600 font-medium">
                  {p.month}/{p.year}
                </td>
                <td className="py-4 text-gray-600">${p.baseSalary?.toLocaleString() || "0"}</td>
                <td className="py-4 text-green-600 font-medium">${p.bonuses?.toLocaleString() || "0"}</td>
                <td className="py-4 text-red-500 font-medium">${p.deductions?.toLocaleString() || "0"}</td>
                <td className="py-4 text-gray-900 font-bold">${p.netSalary?.toLocaleString() || "0"}</td>
                <td className="py-4">{getStatusBadge(p.status)}</td>
                <td className="py-4 pr-6 text-right">
                  <div className="flex items-center justify-end gap-2">
                    {p.status === "PENDING" && (
                      <button 
                        onClick={() => handleUpdateStatus(p.id, "PROCESSED")}
                        className="text-xs px-3 py-1.5 bg-blue-50 text-blue-600 hover:bg-blue-100 rounded font-semibold transition-colors"
                      >
                        Process
                      </button>
                    )}
                    {p.status === "PROCESSED" && (
                      <button 
                        onClick={() => handleUpdateStatus(p.id, "PAID")}
                        className="text-xs px-3 py-1.5 bg-green-50 text-green-600 hover:bg-green-100 rounded font-semibold transition-colors flex items-center gap-1"
                      >
                        <FiCheckCircle /> Mark Paid
                      </button>
                    )}
                  </div>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="8" className="text-center py-8 text-gray-500">
                No payroll records found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default PayrollTable;
