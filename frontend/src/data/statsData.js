import { FiUsers } from "react-icons/fi";
import { IoBriefcaseSharp } from "react-icons/io5";
import { FaPlus, FaMinus } from "react-icons/fa";

export const statsData = [
  {
    id: 1,
    title: "Total Employees",
    value: "3,540",
    percentage: "+25.5%",
    trend: "up",
    icon: FiUsers,
    color: "green",
  },
  {
    id: 2,
    title: "Job Applicants",
    value: "1,150",
    percentage: "+4.1%",
    trend: "up",
    icon: IoBriefcaseSharp,
    color: "blue",
  },
  {
    id: 3,
    title: "New Employees",
    value: "500",
    percentage: "+5.1%",
    trend: "up",
    icon: FaPlus,
    color: "yellow",
  },
  {
    id: 4,
    title: "Resigned",
    value: "93",
    percentage: "-25.5%",
    trend: "down",
    icon: FaMinus,
    color: "red",
  },
];
