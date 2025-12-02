import { z } from "zod";

// refine method for add custom validation logic
export const registerSchema = z
  .object({
    firstName: z
      .string()
      .min(2, "firstName must at lest 3 characters")
      .max(50, "firstName must be at most 50 characters"),
    lastName: z
      .string()
      .min(2, "firstName must at lest 3 characters")
      .max(50, "firstName must be at most 50 characters"),
    email: z.string().email("Invalid email address"),
    password: z
      .string()
      .min(6, "Password must at leat 8 characteres")
      .regex(/[A-Z]/, "Password must contain one uppercase")
      .regex(/[0-9]/, "Password must contain at lest one number"),
    confirmPassword: z.string(),
    acceptTerms: z.boolean().refine((val) => val === true, {
      message: "You must Accept the terms conditions",
    }),
  })
  .refine((data) => data.password === data.confirmPassword, {
    message: "Password do not match",
    path: ["confirmPassword"],
  });
