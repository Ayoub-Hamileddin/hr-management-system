import React from "react";
import { FiSave, FiUser, FiBell, FiLock } from "react-icons/fi";

const Settings = () => {
  return (
    <div className="space-y-6 max-w-5xl">
      {/* Header Area */}
      <div>
        <h1 className="text-3xl font-extrabold text-gray-900">Settings</h1>
        <p className="text-sm text-gray-400 mt-1">
          Configure your HR dashboard preferences and account settings.
        </p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-8">
        {/* Settings Navigation Sidebar */}
        <div className="col-span-1 space-y-1">
          <button className="w-full flex items-center gap-3 px-4 py-3 bg-brand-green/10 text-brand-green rounded-lg font-medium transition-colors">
            <FiUser size={18} />
            Profile
          </button>
          <button className="w-full flex items-center gap-3 px-4 py-3 text-gray-600 hover:bg-gray-50 rounded-lg font-medium transition-colors">
            <FiLock size={18} />
            Security
          </button>
          <button className="w-full flex items-center gap-3 px-4 py-3 text-gray-600 hover:bg-gray-50 rounded-lg font-medium transition-colors">
            <FiBell size={18} />
            Notifications
          </button>
        </div>

        {/* Settings Content Area */}
        <div className="col-span-1 md:col-span-3 space-y-6">
          <div className="card p-8">
            <h2 className="text-xl font-bold text-gray-900 mb-6 border-b border-gray-100 pb-4">Personal Information</h2>
            
            <form className="space-y-6">
              <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <div className="space-y-2">
                  <label className="text-sm font-medium text-gray-700">First Name</label>
                  <input 
                    type="text" 
                    defaultValue="Admin"
                    className="w-full px-4 py-2.5 rounded-lg border border-gray-200 focus:outline-none focus:ring-2 focus:ring-brand-green/20 focus:border-brand-green transition-all"
                  />
                </div>
                <div className="space-y-2">
                  <label className="text-sm font-medium text-gray-700">Last Name</label>
                  <input 
                    type="text" 
                    defaultValue="User"
                    className="w-full px-4 py-2.5 rounded-lg border border-gray-200 focus:outline-none focus:ring-2 focus:ring-brand-green/20 focus:border-brand-green transition-all"
                  />
                </div>
              </div>

              <div className="space-y-2">
                <label className="text-sm font-medium text-gray-700">Email Address</label>
                <input 
                  type="email" 
                  defaultValue="admin@hrsystem.com"
                  className="w-full px-4 py-2.5 rounded-lg border border-gray-200 focus:outline-none focus:ring-2 focus:ring-brand-green/20 focus:border-brand-green transition-all"
                />
              </div>

              <div className="pt-4 flex justify-end">
                <button 
                  type="button" 
                  className="flex items-center gap-2 px-6 py-2.5 bg-brand-green text-white rounded-lg font-medium hover:bg-brand-green/90 transition-colors shadow-sm"
                >
                  <FiSave />
                  Save Changes
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Settings;
