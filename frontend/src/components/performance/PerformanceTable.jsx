import React from "react";
import { format } from "date-fns";
import { useGetAllPerformancesQuery } from "../../features/performance/performanceApi";
import { FiStar } from "react-icons/fi";

const PerformanceTable = ({ searchTerm }) => {
  const { data: performances = [], isLoading, isError } = useGetAllPerformancesQuery();

  const filteredPerformances = performances.filter((p) => {
    const fullName = (p.employeeName || "").toLowerCase();
    return fullName.includes((searchTerm || "").toLowerCase());
  });

  const renderStars = (rating) => {
    return (
      <div className="flex gap-1">
        {[1, 2, 3, 4, 5].map((star) => (
          <FiStar 
            key={star} 
            className={star <= rating ? "text-yellow-400 fill-yellow-400" : "text-gray-300"} 
            size={16} 
          />
        ))}
      </div>
    );
  };

  if (isLoading) return <div className="p-8 text-center text-gray-500">Loading performance data...</div>;
  if (isError) return <div className="p-8 text-center text-red-500">Failed to load performance data.</div>;

  return (
    <div className="overflow-x-auto">
      <table className="w-full text-left border-collapse">
        <thead>
          <tr className="border-b border-gray-200 text-sm font-medium text-gray-500">
            <th className="pb-4 pt-4 pl-6 font-semibold">Employee</th>
            <th className="pb-4 pt-4 font-semibold">Reviewer</th>
            <th className="pb-4 pt-4 font-semibold">Review Date</th>
            <th className="pb-4 pt-4 font-semibold">Rating</th>
            <th className="pb-4 pt-4 font-semibold w-1/3">Comments</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {filteredPerformances.length > 0 ? (
            filteredPerformances.map((p) => (
              <tr key={p.id} className="border-b border-gray-100 hover:bg-gray-50 transition-colors">
                <td className="py-4 pl-6 font-semibold text-gray-900">{p.employeeName}</td>
                <td className="py-4 text-gray-600 font-medium">{p.reviewerName || "-"}</td>
                <td className="py-4 text-gray-600">
                  {p.reviewDate ? format(new Date(p.reviewDate), "dd MMM yyyy") : "-"}
                </td>
                <td className="py-4">
                  {renderStars(p.rating)}
                </td>
                <td className="py-4 text-gray-500 pr-6">
                  <p className="truncate max-w-md">{p.comments || "No comments."}</p>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center py-8 text-gray-500">
                No performance reviews found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default PerformanceTable;
