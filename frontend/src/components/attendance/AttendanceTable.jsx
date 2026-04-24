import React from "react";
import { format } from "date-fns";
import { useGetAllAttendancesQuery } from "../../features/attendance/attendanceApi";

const AttendanceTable = ({ searchTerm }) => {
  const { data: attendances = [], isLoading, isError } = useGetAllAttendancesQuery();

  const filteredAttendances = attendances.filter((a) => {
    const fullName = (a.employeeName || "").toLowerCase();
    return fullName.includes((searchTerm || "").toLowerCase());
  });

  const getStatusBadge = (status) => {
    switch (status) {
      case "PRESENT":
        return <span className="px-3 py-1 bg-green-100 text-green-700 rounded-full text-xs font-semibold">Present</span>;
      case "ABSENT":
        return <span className="px-3 py-1 bg-red-100 text-red-700 rounded-full text-xs font-semibold">Absent</span>;
      case "LATE":
        return <span className="px-3 py-1 bg-yellow-100 text-yellow-700 rounded-full text-xs font-semibold">Late</span>;
      case "HALF_DAY":
        return <span className="px-3 py-1 bg-blue-100 text-blue-700 rounded-full text-xs font-semibold">Half Day</span>;
      default:
        return <span className="px-3 py-1 bg-gray-100 text-gray-700 rounded-full text-xs font-semibold">{status}</span>;
    }
  };

  const formatTime = (timeString) => {
    if (!timeString) return "-";
    // Assuming timeString is HH:MM:SS
    const [hours, minutes] = timeString.split(":");
    const h = parseInt(hours, 10);
    const ampm = h >= 12 ? 'PM' : 'AM';
    const h12 = h % 12 || 12;
    return `${h12}:${minutes} ${ampm}`;
  };

  if (isLoading) return <div className="p-8 text-center text-gray-500">Loading attendance data...</div>;
  if (isError) return <div className="p-8 text-center text-red-500">Failed to load attendance data.</div>;

  return (
    <div className="overflow-x-auto">
      <table className="w-full text-left border-collapse">
        <thead>
          <tr className="border-b border-gray-200 text-sm font-medium text-gray-500">
            <th className="pb-4 pt-4 pl-6 font-semibold">Employee</th>
            <th className="pb-4 pt-4 font-semibold">Date</th>
            <th className="pb-4 pt-4 font-semibold">Check In</th>
            <th className="pb-4 pt-4 font-semibold">Check Out</th>
            <th className="pb-4 pt-4 pr-6 font-semibold">Status</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {filteredAttendances.length > 0 ? (
            filteredAttendances.map((a) => (
              <tr key={a.id} className="border-b border-gray-100 hover:bg-gray-50 transition-colors">
                <td className="py-4 pl-6 font-semibold text-gray-900">{a.employeeName}</td>
                <td className="py-4 text-gray-600 font-medium">
                  {a.date ? format(new Date(a.date), "dd MMM yyyy") : "-"}
                </td>
                <td className="py-4 text-gray-600">{formatTime(a.checkIn)}</td>
                <td className="py-4 text-gray-600">{formatTime(a.checkOut)}</td>
                <td className="py-4 pr-6">{getStatusBadge(a.status)}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center py-8 text-gray-500">
                No attendance records found.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default AttendanceTable;
