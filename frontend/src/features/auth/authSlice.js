import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
  name: "auth",
  initialState: {
    user: null,
    accessToken: null,
    refreshToken: null,
  },
  reducers: {
    setCredentials: (state, action) => {
      state.user = action.payload.user;
      state.accessToken = action.payload.accessToken;
    },
    logout: (state) => {
      state.user = null;
      state.accessToken = null;
      state.refreshToken = null;
    },
  },
});
export const { setCredentials, logout } = authSlice.actions;
export default authSlice.reducer;
export const selectcurrentUser = (state) => state.auth.user;
export const selectcurrentAccessToken = (state) => state.auth.accessToken;
