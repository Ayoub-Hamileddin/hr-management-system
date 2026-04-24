import { baseApi } from "../../app/api/baseApi";

export const payrollApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    getAllPayrolls: builder.query({
      query: () => ({
        url: "/payroll",
        method: "GET",
      }),
      providesTags: ["Payroll"],
    }),
    updatePayrollStatus: builder.mutation({
      query: ({ id, status }) => ({
        url: `/payroll/${id}`,
        method: "PUT",
        body: { status },
      }),
      invalidatesTags: ["Payroll"],
    }),
  }),
});

export const {
  useGetAllPayrollsQuery,
  useUpdatePayrollStatusMutation,
} = payrollApi;
