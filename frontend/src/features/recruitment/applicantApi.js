import { baseApi } from "../../app/api/baseApi";

export const applicantApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    getAllApplicants: builder.query({
      query: () => ({
        url: "/applicants",
        method: "GET",
      }),
      providesTags: ["Applicant"],
    }),
    getApplicantById: builder.query({
      query: (id) => ({
        url: `/applicants/${id}`,
        method: "GET",
      }),
      providesTags: (result, error, id) => [{ type: "Applicant", id }],
    }),
    createApplicant: builder.mutation({
      query: (applicantData) => ({
        url: "/applicants",
        method: "POST",
        body: applicantData,
      }),
      invalidatesTags: ["Applicant"],
    }),
    updateApplicantStatus: builder.mutation({
      query: ({ id, ...data }) => ({
        url: `/applicants/${id}`,
        method: "PUT",
        body: data,
      }),
      invalidatesTags: (result, error, { id }) => [{ type: "Applicant", id }, "Applicant"],
    }),
    deleteApplicant: builder.mutation({
      query: (id) => ({
        url: `/applicants/${id}`,
        method: "DELETE",
      }),
      invalidatesTags: ["Applicant"],
    }),
  }),
});

export const {
  useGetAllApplicantsQuery,
  useGetApplicantByIdQuery,
  useCreateApplicantMutation,
  useUpdateApplicantStatusMutation,
  useDeleteApplicantMutation,
} = applicantApi;
