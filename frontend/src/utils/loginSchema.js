import { z } from "zod";

export const loginSchema = z.object({
  email: z.string().email("Invalid email address"),
  password: z
    .string()
    .min(6, "Password must at least 8 characters")
    .regex(/[A-Z]/, "Password must contain at lest one UpperCase")
    .regex(/[0-9]/, "Password must contain at least one number"),
  rememberMe: z.boolean().refine((val) => val === true, {
    message: "You must accept the terms condition",
  }),
});
