import React from 'react';
import {FaCalendarDay} from "react-icons/fa";
const BlogItem:React.FC = () => {
    return (
        <div className={'grid grid-cols-1 gap-4 shadow_primary hover:scale-105 transition-all duration-300 cursor-pointer p-4'}>
            <div>
                <img src={"https://demo.templatesjungle.com/foodfarm/images/post-thumbnail-1.jpg"} alt={'blog'}/>
            </div>
            <div>
                <div className={'flex items-center gap-4 justify-center text-gray-300'}><FaCalendarDay /> 22 Aug 2021</div>
                <h3  className={'text-2xl font-bold title-shortcut'}>Top 10 casual look ideas to dress up your kids</h3>
                <p className={'shortcut'}>Lorem ipsum dolor sit amet, consectetur adipi elit. Aliquet eleifend viverra enim tincidunt donec quam. A in arcu, hendrerit neque dolor morbi...</p>
            </div>
        </div>
    );
};

export default BlogItem;