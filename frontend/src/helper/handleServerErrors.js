export function handleServerErrors(error, setError, toast) {
  /*
   *server can return multiple form of errors:
   *  1-validation map.
   *  2-single message.
   *  2-Array of errors.
   *  3-Network error.
   *  so we have to handle all these errors from the server
   */

  const data = error?.data;

  // errors map { field: message }
  if (
    data?.errors &&
    typeof data?.errors == "object" &&
    !Array.isArray(data?.errors)
  ) {
    Object.entries(data?.errors).forEach(([field, message]) => {
      setError(field, {
        type: "server",
        message: message,
      });
    });
    return;
  }

  // errors array [{field, message}]
  if (Array.isArray(data?.errors)) {
    data.errors.forEach((errItem) => {
      if (errItem.field) {
        setError(errItem.field, {
          type: "server",
          message: errItem.message,
        });
      } else {
        toast.error(errItem.message || "An error occurred");
      }
    });
    return;
  }

  // normal message
  if (data?.message) {
    toast.error(data.message);
    return;
  }

  //   fallback: network / unknown
  toast.error("Something went wrong. Please try again.");
}
