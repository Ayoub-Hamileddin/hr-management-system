import { baseApi } from "../../app/api/baseApi";

const authApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    register: builder.mutation({
      query: (registerData) => ({
        url: "/auth/register",
        method: "POST",
        body: { ...registerData },
      }),
    }),
    login: builder.mutation({
      query: (credentials) => ({
        url: "/auth/login",
        method: "POST",
        body: { ...credentials },
      }),
    }),
    refresh: builder.mutation({
      query: (refreshToken) => ({
        url: "/auth/refresh",
        method: "POST",
        body: { ...refreshToken },
      }),
    }),
    me: builder.query({
      query: () => ({
        url: "/auth/me",
        method: "GET",
      }),
    }),
  }),
});

export const {
  useLoginMutation,
  useMeQuery,
  useRegisterMutation,
  useRefreshMutation,
} = authApi;
