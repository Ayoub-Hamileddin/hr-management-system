import { CiCalendarDate, CiMoneyCheck1 } from "react-icons/ci";
import { FiUsers, FiHome } from "react-icons/fi";
import { HiMiniArrowTrendingUp } from "react-icons/hi2";
import { IoBriefcaseSharp } from "react-icons/io5";
import { MdTimer } from "react-icons/md";

export const navLinks = [
  {
    id: 1,
    label: "Dashboard",
    path: "/dashboard",
    Icon: FiHome,
    hasArrow: false,
    end: true,
  },
  {
    id: 2,
    label: "Employees",
    path: "/dashboard/employees",
    Icon: FiUsers,
    hasArrow: false,
  },
  {
    id: 3,
    label: "Time Off",
    path: "/dashboard/timeoff",
    Icon: MdTimer,
    hasArrow: false,
  },
  {
    id: 4,
    label: "Attendance",
    path: "/dashboard/attendance",
    Icon: CiCalendarDate,
    hasArrow: false,
  },
  {
    id: 5,
    label: "Payroll",
    path: "/dashboard/payroll",
    Icon: CiMoneyCheck1,
    hasArrow: false,
  },
  {
    id: 6,
    label: "Performance",
    path: "/dashboard/performance",
    Icon: HiMiniArrowTrendingUp,
    hasArrow: false,
  },
  {
    id: 7,
    label: "Recruitment",
    path: "/dashboard/recruitment",
    Icon: IoBriefcaseSharp,
    hasArrow: false,
  },
];
