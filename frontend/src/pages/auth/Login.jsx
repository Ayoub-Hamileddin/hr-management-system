import React from "react";
import { useLoginMutation } from "../../features/auth/authApi";
import { setCredentials } from "../../features/auth/authSlice";
import { useDispatch } from "react-redux";
import { useForm } from "react-hook-form";
import { loginSchema } from "../../utils/loginSchema";
import { zodResolver } from "@hookform/resolvers/zod";
import { Link, useNavigate } from "react-router-dom";
import { handleServerErrors } from "../../helper/handleServerErrors";
import { toast } from "sonner";
const Login = () => {
  const [login, { isLoading }] = useLoginMutation();
  const dispatch = useDispatch();
  const {
    register,
    handleSubmit,
    setErrors,
    formState: { errors, isSubmitting },
  } = useForm({
    resolver: zodResolver(loginSchema),
  });
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    try {
      const credentials = await login({
        email: data.email,
        password: data.password,
      });
      dispatch(setCredentials({ ...credentials }));
      toast.success("Login Successfuly");
      navigate("/");
    } catch (error) {
      console.log(error);

      handleServerErrors(error, setErrors, toast);
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="relative flex flex-col m-6 space-y-8 bg-white shadow-2xl rounded-2xl md:flex-row md:space-y-0  ">
        <div className="flex flex-col justify-center p-8 md:p-14">
          <span className="mb-3 text-4xl font-bold">Welcome Back</span>
          <span className="font-light text-gray-400 mb-8">
            Welcome Back ! Please Enter Your Details
          </span>
          {/* form */}
          <form onSubmit={handleSubmit(onSubmit)}>
            <div className="mt-4">
              <span className="mb-2 text-base">Email</span>
              <input
                {...register("email")}
                type="email"
                name="email"
                id="email"
                className="w-full p-2 rounded-md border border-gray-300 placeholder:font-light placeholder:text-gray-500"
                placeholder="name@company.com"
                required=""
              />
            </div>
            {errors.email && (
              <span className="text-red-600 font-light text-xs">
                {errors.email.message}
              </span>
            )}
            <div className="mt-4">
              <span className="mb-2 text-base">Password</span>
              <input
                {...register("password")}
                type="password"
                name="password"
                id="password"
                placeholder="••••••••"
                className="w-full p-2 border border-gray-300 rounded-md placeholder:font-light placeholder:text-gray-500"
                required=""
              />
            </div>
            {errors.password && (
              <span className="text-red-600 font-light text-xs">
                {errors.password.message}
              </span>
            )}
            <div className="flex justify-between w-full pt-4">
              <div className="mr-24">
                <input
                  {...register("acceptTerms")}
                  id="terms"
                  aria-describedby="terms"
                  type="checkbox"
                  required=""
                  className="mr-2"
                />
                <span className="text-base">remember for 30 days </span>
              </div>
              <span className="font-bold text-base underline">
                Forgot password{" "}
              </span>
            </div>
            {errors.acceptTerms && (
              <span className="text-red-600 font-light text-xs">
                {errors.acceptTerms.message}
              </span>
            )}
            <button
              disabled={isLoading || isSubmitting}
              className="w-full bg-black text-white text-md font-semibold p-2  mt-5 rounded-lg mb-6 hover:bg-white hover:text-black hover:border hover:border-gray-300 "
            >
              {isSubmitting ? "Sign In ..." : "Sign In"}
            </button>
            <button className="w-full border border-gray-300 text-md font-semibold p-2 rounded-lg mb-6 hover:bg-black hover:text-white">
              <img
                src="src/assets/images/google.svg"
                alt="google-svg"
                className="w-6 h-6  inline mr-2"
              />
              Sign In with Google
            </button>
          </form>
          {/* end form */}
          <div className="text-center text-gray-400">
            Dont'have an account ?
            <span className="font-bold text-black underline">
              {" "}
              Sign up for free
            </span>
          </div>
        </div>
        <div className="relative">
          <img
            src="src/assets/images/hr-bg2.png"
            alt=""
            className="w-[400px] h-full hidden rounded-r-2xl md:block object-cover"
          />
          {/* text on image */}
          <div
            className="absolute hidden bottom-10 right-6 p-6 bg-black bg-opacity-30 backdrop-blur-sm
            rounded drop-shadow-lg md:block font-bold text-center
          "
          >
            <span className="text-white text-xl">
              Let' s manage your employees
            </span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
