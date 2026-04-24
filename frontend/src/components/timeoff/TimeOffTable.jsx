import React from "react";
import { FiCheckCircle, FiXCircle } from "react-icons/fi";
import { format } from "date-fns";
import { 
  useGetAllLeaveRequestsQuery, 
  useUpdateLeaveRequestStatusMutation 
} from "../../features/timeoff/timeoffApi";

const TimeOffTable = ({ searchTerm }) => {
  const { data: requests = [], isLoading, isError } = useGetAllLeaveRequestsQuery();
  const [updateStatus] = useUpdateLeaveRequestStatusMutation();

  const filteredRequests = requests.filter((req) => {
    const fullName = (req.employeeName || "").toLowerCase();
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
      case "APPROVED":
        return <span className="px-3 py-1 bg-green-100 text-green-700 rounded-full text-xs font-semibold">Approved</span>;
      case "REJECTED":
        return <span className="px-3 py-1 bg-red-100 text-red-700 rounded-full text-xs font-semibold">Rejected</span>;
      default:
        return <span className="px-3 py-1 bg-yellow-100 text-yellow-700 rounded-full text-xs font-semibold">Pending</span>;
    }
  };

  if (isLoading) return <div className="p-8 text-center text-gray-500">Loading requests...</div>;
  if (isError) return <div className="p-8 text-center text-red-500">Failed to load requests.</div>;

  return (
    <div className="overflow-x-auto">
      <table className="w-full text-left border-collapse">
        <thead>
          <tr className="border-b border-gray-200 text-sm font-medium text-gray-500">
            <th className="pb-4 pt-4 pl-6 font-semibold">Employee</th>
            <th className="pb-4 pt-4 font-semibold">Leave Type</th>
            <th className="pb-4 pt-4 font-semibold">Start Date</th>
            <th className="pb-4 pt-4 font-semibold">End Date</th>
            <th className="pb-4 pt-4 font-semibold">Status</th>
            <th className="pb-4 pt-4 pr-6 font-semibold text-right">Action</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {filteredRequests.length > 0 ? (
            filteredRequests.map((req) => (
              <tr key={req.id} className="border-b border-gray-100 hover:bg-gray-50 transition-colors">
                <td className="py-4 pl-6 font-semibold text-gray-900">{req.employeeName}</td>
                <td className="py-4 text-gray-600 font-medium">{req.type}</td>
                <td className="py-4 text-gray-600">
                  {req.startDate ? format(new Date(req.startDate), "dd MMM yyyy") : "-"}
                </td>
                <td className="py-4 text-gray-600">
                  {req.endDate ? format(new Date(req.endDate), "dd MMM yyyy") : "-"}
                </td>
                <td className="py-4">{getStatusBadge(req.status)}</td>
                <td className="py-4 pr-6 text-right">
                  <div className="flex items-center justify-end gap-2">
                    {req.status === "PENDING" && (
                      <>
                        <button 
                          onClick={() => handleUpdateStatus(req.id, "APPROVED")}
                          className="p-2 bg-green-50 text-green-600 hover:bg-green-100 rounded-md transition-colors"
                          title="Approve"
                        >
                          <FiCheckCircle size={16} />
                        </button>
                        <button 
                          onClick={() => handleUpdateStatus(req.id, "REJECTED")}
                          className="p-2 bg-red-50 text-red-600 hover:bg-red-100 rounded-md transition-colors"
                          title="Reject"
                        >
                          <FiXCircle size={16} />
                        </button>
                      </>
                    )}
                  </div>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6" className="text-center py-8 text-gray-500">
                No leave requests found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default TimeOffTable;
