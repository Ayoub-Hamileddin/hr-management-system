import { baseApi } from "../../app/api/baseApi";

export const performanceApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    getAllPerformances: builder.query({
      query: () => ({
        url: "/performance",
        method: "GET",
      }),
      providesTags: ["Performance"],
    }),
  }),
});

export const {
  useGetAllPerformancesQuery,
} = performanceApi;
