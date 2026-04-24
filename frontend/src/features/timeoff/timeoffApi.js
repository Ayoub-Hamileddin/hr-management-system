import { baseApi } from "../../app/api/baseApi";

export const timeoffApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    getAllLeaveRequests: builder.query({
      query: () => ({
        url: "/timeoff",
        method: "GET",
      }),
      providesTags: ["TimeOff"],
    }),
    updateLeaveRequestStatus: builder.mutation({
      query: ({ id, status }) => ({
        url: `/timeoff/${id}`,
        method: "PUT",
        body: { status },
      }),
      invalidatesTags: ["TimeOff"],
    }),
    deleteLeaveRequest: builder.mutation({
      query: (id) => ({
        url: `/timeoff/${id}`,
        method: "DELETE",
      }),
      invalidatesTags: ["TimeOff"],
    }),
  }),
});

export const {
  useGetAllLeaveRequestsQuery,
  useUpdateLeaveRequestStatusMutation,
  useDeleteLeaveRequestMutation,
} = timeoffApi;
