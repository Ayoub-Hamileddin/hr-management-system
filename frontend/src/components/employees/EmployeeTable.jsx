import React from "react";

const EmployeeTable = () => {
  return (
    <>
      <div class="relative overflow-x-auto bg-neutral-primary-soft shadow-xs rounded-base border border-default mt-6  rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-body">
          <thead class="text-sm  bg-gray-50 border-b border-t border-default-medium">
            <tr>
              <th scope="col" class="p-4">
                <div class="flex items-center">
                  <input
                    id="table-checkbox-45"
                    type="checkbox"
                    value=""
                    class="w-4 h-4 border border-default-medium rounded-xs bg-neutral-secondary-medium focus:ring-2 focus:ring-brand-soft"
                  />
                  <label for="table-checkbox-45" class="sr-only">
                    Table checkbox
                  </label>
                </div>
              </th>
              <th scope="col" class="px-6 py-3 font-semibold text-gray-700">
                Name
              </th>
              <th scope="col" class="px-6 py-3 font-semibold text-gray-700">
                Position
              </th>
              <th scope="col" class="px-6 py-3 font-semibold text-gray-700">
                Status
              </th>
              <th scope="col" class="px-6 py-3 font-semibold text-gray-700">
                Action
              </th>
            </tr>
          </thead>
          <tbody>
            <tr class="bg-neutral-primary-soft border-b border-default hover:bg-gray-50">
              <td class="w-4 p-4">
                <div class="flex items-center">
                  <input
                    id="table-checkbox-46"
                    type="checkbox"
                    value=""
                    class="w-4 h-4 border border-default-medium rounded-xs bg-neutral-secondary-medium focus:ring-2 focus:ring-brand-soft"
                  />
                  <label for="table-checkbox-46" class="sr-only">
                    Table checkbox
                  </label>
                </div>
              </td>
              <th
                scope="row"
                class="flex items-center px-6 py-4 text-heading whitespace-nowrap"
              >
                <img
                  class="w-10 h-10 rounded-full object-cover"
                  src="images/avatar.jpg"
                  alt="Jese image"
                />
                <div class="ps-3">
                  <div class="text-base font-semibold">Neil Sims</div>
                  <div class="font-normal text-body">
                    neil.sims@flowbite.com
                  </div>
                </div>
              </th>
              <td class="px-6 py-4">React Developer</td>
              <td class="px-6 py-4">
                <div class="flex items-center">
                  <div class="h-2.5 w-2.5 rounded-full bg-green-600 me-2"></div>{" "}
                  Online
                </div>
              </td>
              <td class="px-6 py-4">
                <a href="#" class="font-semibold text-blue-600 hover:underline">
                  Edit user
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </>
  );
};

export default EmployeeTable;
