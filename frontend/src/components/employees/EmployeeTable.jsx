import React, { useState } from "react";
import { useGetAllEmployeesQuery, useDeleteEmployeeMutation } from "../../features/employees/employeeApi";
import { FiEdit2, FiTrash2, FiSearch, FiPlus } from "react-icons/fi";
import AddEmployeeModal from "./AddEmployeeModal";
import EditEmployeeModal from "./EditEmployeeModal";
import { toast } from "sonner";

const getInitials = (firstName, lastName) =>
  `${firstName?.[0] || ""}${lastName?.[0] || ""}`.toUpperCase();

const avatarColors = [
  "bg-brand text-white",
  "bg-accent text-gray-900",
  "bg-indigo-100 text-indigo-600",
  "bg-pink-100 text-pink-600",
  "bg-orange-100 text-orange-600",
];

const EmployeeTable = () => {
  const { data: employees, isLoading, isError } = useGetAllEmployeesQuery();
  const [deleteEmployee] = useDeleteEmployeeMutation();
  const [search, setSearch] = useState("");
  const [isAddOpen, setIsAddOpen] = useState(false);
  const [editEmployee, setEditEmployee] = useState(null);

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this employee?")) {
      try {
        await deleteEmployee(id).unwrap();
        toast.success("Employee deleted successfully");
      } catch (error) {
        toast.error("Failed to delete employee");
      }
    }
  };

  const filteredEmployees = employees?.filter((emp) =>
    `${emp.firstName} ${emp.lastName}`.toLowerCase().includes(search.toLowerCase()) ||
    emp.department?.name?.toLowerCase().includes(search.toLowerCase()) ||
    emp.position?.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="card">
      <div className="flex flex-col md:flex-row items-center justify-between gap-4 mb-6">
        <h2 className="text-xl font-bold text-gray-900">All Employees</h2>
        <div className="flex items-center gap-3 w-full md:w-auto">
          <div className="relative w-full md:w-64">
            <FiSearch className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" />
            <input
              type="text"
              placeholder="Search employee..."
              className="input-field pl-10 py-2"
              value={search}
              onChange={(e) => setSearch(e.target.value)}
            />
          </div>
          <button
            onClick={() => setIsAddOpen(true)}
            className="btn-primary flex items-center gap-2 shrink-0 py-2"
          >
            <FiPlus /> Add Employee
          </button>
        </div>
      </div>

      <div className="overflow-x-auto">
        {isLoading ? (
          <div className="p-8 text-center text-gray-500">Loading employees...</div>
        ) : isError ? (
          <div className="p-8 text-center text-red-500">Failed to load employees</div>
        ) : filteredEmployees?.length === 0 ? (
          <div className="p-8 text-center text-gray-500">No employees found.</div>
        ) : (
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="border-b border-gray-100">
                <th className="py-3 px-4 text-xs font-semibold text-gray-400 uppercase tracking-wider">Name</th>
                <th className="py-3 px-4 text-xs font-semibold text-gray-400 uppercase tracking-wider">Position</th>
                <th className="py-3 px-4 text-xs font-semibold text-gray-400 uppercase tracking-wider">Department</th>
                <th className="py-3 px-4 text-xs font-semibold text-gray-400 uppercase tracking-wider">Status</th>
                <th className="py-3 px-4 text-xs font-semibold text-gray-400 uppercase tracking-wider text-right">Actions</th>
              </tr>
            </thead>
            <tbody>
              {filteredEmployees?.map((emp, idx) => (
                <tr key={emp.id} className="border-b border-gray-50 hover:bg-gray-50/50 transition-colors">
                  <td className="py-3 px-4">
                    <div className="flex items-center gap-3">
                      <div className={`w-10 h-10 rounded-full flex items-center justify-center text-sm font-bold shrink-0 ${avatarColors[idx % avatarColors.length]}`}>
                        {getInitials(emp.firstName, emp.lastName)}
                      </div>
                      <div>
                        <p className="text-sm font-bold text-gray-900">{emp.firstName} {emp.lastName}</p>
                        <p className="text-xs text-gray-500">{emp.email}</p>
                      </div>
                    </div>
                  </td>
                  <td className="py-3 px-4 text-sm text-gray-600">{emp.position}</td>
                  <td className="py-3 px-4 text-sm text-gray-600">{emp.department?.name || "N/A"}</td>
                  <td className="py-3 px-4">
                    <span className={emp.status === "ACTIVE" ? "badge-active" : "badge-inactive"}>
                      <span className={`w-1.5 h-1.5 rounded-full ${emp.status === "ACTIVE" ? "bg-green-500" : "bg-gray-400"}`} />
                      {emp.status === "ACTIVE" ? "Active" : "Inactive"}
                    </span>
                  </td>
                  <td className="py-3 px-4">
                    <div className="flex items-center justify-end gap-2">
                      <button
                        onClick={() => setEditEmployee(emp)}
                        className="p-2 text-gray-400 hover:text-brand hover:bg-brand-50 rounded-lg transition-colors"
                        title="Edit"
                      >
                        <FiEdit2 size={16} />
                      </button>
                      <button
                        onClick={() => handleDelete(emp.id)}
                        className="p-2 text-gray-400 hover:text-red-500 hover:bg-red-50 rounded-lg transition-colors"
                        title="Delete"
                      >
                        <FiTrash2 size={16} />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>

      <AddEmployeeModal isOpen={isAddOpen} onClose={() => setIsAddOpen(false)} />
      <EditEmployeeModal
        isOpen={!!editEmployee}
        onClose={() => setEditEmployee(null)}
        employee={editEmployee}
      />
    </div>
  );
};

export default EmployeeTable;
