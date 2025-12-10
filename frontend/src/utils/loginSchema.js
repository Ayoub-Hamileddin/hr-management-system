import { z } from "zod";

export const loginSchema = z.object({
  email: z.string().email("Invalid email address"),
  password: z
    .string()
    .min(6, "Password must at least 8 characters")
    .regex(/[A-Z]/, "Password must contain at lest one UpperCase")
    .regex(/[0-9]/, "Password must contain at least one number"),
  acceptTerms: z.boolean().refine((val) => val === true, {
    message: "You must Accept the terms conditions",
  }),
});
