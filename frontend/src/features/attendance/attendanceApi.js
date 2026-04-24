import { baseApi } from "../../app/api/baseApi";

export const attendanceApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    getAllAttendances: builder.query({
      query: () => ({
        url: "/attendance",
        method: "GET",
      }),
      providesTags: ["Attendance"],
    }),
  }),
});

export const {
  useGetAllAttendancesQuery,
} = attendanceApi;
