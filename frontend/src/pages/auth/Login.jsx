/* eslint-disable no-unused-vars */
import React from "react";
import { useForm } from "react-hook-form";
import { toast, Toaster } from "sonner";
const Login = () => {
  const {
    register,
    handleSubmit,
    setError,
    formState: { errors, isSubmitting },
  } = useForm();
  const onSubmit = async (data) => {
    try {
      await new Promise((resolver) => setTimeout(resolver, 3000));
      throw new Error();
      console.log(data);
    } catch (error) {
      setError("root.serverCatch", {
        type: "server",
        message: error.message,
      });
      toast.error("register failed");
    }
  };
  return (
    <div>
      <Toaster position="top-left" richColors />
      <form onSubmit={handleSubmit(onSubmit)}>
        <input
          {...register("email", {
            required: "Email is required",
          })}
          type="text"
        />{" "}
        <br />
        {/* {errors.root.type === "server" && <p>server error message</p>} */}
        <p>{errors.root}</p>
        {errors.email && <p>{errors.email.message}</p>}
        <input
          {...register("password", {
            required: "Password is Required",
          })}
          type="text"
        />{" "}
        <br />
        {errors.password && <p>{errors.password.message}</p>}
        <button disabled={isSubmitting} type="submit">
          {isSubmitting ? "loading ...." : "submit"}
        </button>
      </form>
    </div>
  );
};

export default Login;
