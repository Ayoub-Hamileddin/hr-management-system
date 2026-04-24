import React, { useState } from "react";
import { FiEdit2, FiTrash2, FiFileText } from "react-icons/fi";
import { format } from "date-fns";
import { 
  useGetAllApplicantsQuery, 
  useUpdateApplicantStatusMutation,
  useDeleteApplicantMutation 
} from "../../features/recruitment/applicantApi";

const statusOptions = [
  "NEW",
  "INTERVIEWING",
  "OFFERED",
  "REJECTED",
  "HIRED"
];

const statusToDisplay = {
  "NEW": "Applied",
  "INTERVIEWING": "1st Interview", // Simplifying for UI
  "OFFERED": "Hiring",
  "REJECTED": "Rejected",
  "HIRED": "Hired"
};

const RecruitmentTable = ({ searchTerm }) => {
  const { data: applicants = [], isLoading, isError } = useGetAllApplicantsQuery();
  const [updateStatus] = useUpdateApplicantStatusMutation();
  const [deleteApplicant] = useDeleteApplicantMutation();

  const filteredApplicants = applicants.filter((applicant) => {
    const fullName = `${applicant.firstName} ${applicant.lastName}`.toLowerCase();
    return fullName.includes((searchTerm || "").toLowerCase());
  });

  const handleStatusChange = async (id, newStatus) => {
    try {
      await updateStatus({ id, status: newStatus }).unwrap();
    } catch (err) {
      console.error("Failed to update status", err);
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this applicant?")) {
      try {
        await deleteApplicant(id).unwrap();
      } catch (err) {
        console.error("Failed to delete applicant", err);
      }
    }
  };

  if (isLoading) {
    return <div className="text-center p-8 text-gray-500">Loading applicants...</div>;
  }

  if (isError) {
    return <div className="text-center p-8 text-red-500">Failed to load applicants.</div>;
  }

  return (
    <div className="overflow-x-auto">
      <table className="w-full text-left border-collapse">
        <thead>
          <tr className="border-b border-gray-200 text-sm font-medium text-gray-500">
            <th className="pb-4 pt-4 pl-4 font-semibold">Name</th>
            <th className="pb-4 pt-4 font-semibold">Phone Number</th>
            <th className="pb-4 pt-4 font-semibold">CV</th>
            <th className="pb-4 pt-4 font-semibold">Created Date</th>
            <th className="pb-4 pt-4 font-semibold">Stages</th>
            <th className="pb-4 pt-4 pr-4 font-semibold text-right">Action</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {filteredApplicants.length > 0 ? (
            filteredApplicants.map((applicant) => (
              <tr
                key={applicant.id}
                className="border-b border-gray-100 hover:bg-gray-50 transition-colors"
              >
                <td className="py-4 pl-4 flex items-center gap-3">
                  <div className="w-10 h-10 rounded-full bg-brand-green/20 text-brand-green flex items-center justify-center font-bold">
                    {applicant.firstName[0]}
                    {applicant.lastName[0]}
                  </div>
                  <div>
                    <div className="font-semibold text-gray-900">
                      {applicant.firstName} {applicant.lastName}
                    </div>
                    <div className="text-gray-400 text-xs">{applicant.email}</div>
                  </div>
                </td>
                <td className="py-4 text-gray-600">{applicant.phone || "-"}</td>
                <td className="py-4">
                  {applicant.resumeUrl ? (
                    <div className="flex items-center gap-2 text-gray-600">
                      <span>CV.pdf</span>
                      <FiFileText className="text-gray-400" />
                    </div>
                  ) : (
                    <span className="text-gray-400">-</span>
                  )}
                </td>
                <td className="py-4 text-gray-600">
                  {applicant.appliedDate ? format(new Date(applicant.appliedDate), "dd MMM yyyy") : "-"}
                </td>
                <td className="py-4">
                  <select
                    value={applicant.status}
                    onChange={(e) => handleStatusChange(applicant.id, e.target.value)}
                    className="border-none bg-transparent text-gray-700 font-medium focus:ring-0 cursor-pointer"
                  >
                    {statusOptions.map(status => (
                      <option key={status} value={status}>
                        {statusToDisplay[status]}
                      </option>
                    ))}
                  </select>
                </td>
                <td className="py-4 pr-4 text-right">
                  <div className="flex items-center justify-end gap-2">
                    <button className="p-2 bg-blue-500 hover:bg-blue-600 text-white rounded-md transition-colors">
                      <FiEdit2 size={14} />
                    </button>
                    <button 
                      onClick={() => handleDelete(applicant.id)}
                      className="p-2 bg-red-500 hover:bg-red-600 text-white rounded-md transition-colors"
                    >
                      <FiTrash2 size={14} />
                    </button>
                  </div>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6" className="text-center py-8 text-gray-500">
                No applicants found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
      
      {/* Pagination footer (Mocked for UI) */}
      <div className="flex justify-between items-center mt-6 text-sm text-gray-500 border-t border-gray-100 pt-4">
        <div>
          Showing 1 to {filteredApplicants.length} of {filteredApplicants.length} entries
        </div>
        <div className="flex items-center gap-2">
          <span className="flex items-center gap-2 border border-gray-200 rounded px-2 py-1">
            Show 8
            <svg className="w-3 h-3" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M19 9l-7 7-7-7"></path></svg>
          </span>
          <div className="flex border border-gray-200 rounded overflow-hidden">
            <button className="px-3 py-1 hover:bg-gray-50 border-r border-gray-200 text-gray-400">&lt;</button>
            <button className="px-3 py-1 bg-brand-green text-white">1</button>
            <button className="px-3 py-1 hover:bg-gray-50 text-gray-400">&gt;</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RecruitmentTable;
