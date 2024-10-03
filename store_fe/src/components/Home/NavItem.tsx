import React from 'react';
import {IoFastFood} from "react-icons/io5";

const NavItem = () => {
    return (
        <div className={'bg-green_primary text-white p-4 flex gap-2 items-center cursor-pointer border-dotted border-b-2 text-xl'}>
            <IoFastFood />  <span>Breakfast Foods</span>
        </div>
    );
};

export default NavItem;