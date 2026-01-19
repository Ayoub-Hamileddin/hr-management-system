import { CiCalendarDate, CiMoneyCheck1 } from "react-icons/ci";
import { FiUsers } from "react-icons/fi";
import { HiMiniArrowTrendingUp } from "react-icons/hi2";
import { IoBriefcaseSharp } from "react-icons/io5";
import { MdTimer } from "react-icons/md";

export const navLinks = [
  {
    id: 2,
    label: "Employees",
    path: "/employees",
    Icon: FiUsers,
    hasArrow: true,
  },
  {
    id: 3,
    label: "Time Off",
    path: "/timeoff",
    Icon: MdTimer,
    hasArrow: true,
  },
  {
    id: 4,
    label: "Attendance",
    path: "/attendance",
    Icon: CiCalendarDate,
    hasArrow: true,
  },
  {
    id: 5,
    label: "Payroll",
    path: "/payroll",
    Icon: CiMoneyCheck1,
    hasArrow: true,
  },
  {
    id: 6,
    label: "Performance",
    path: "/performance",
    Icon: HiMiniArrowTrendingUp,
    hasArrow: true,
  },
  {
    id: 7,
    label: "Recrutement",
    path: "/recrutment",
    Icon: IoBriefcaseSharp,
    hasArrow: true,
  },
];
