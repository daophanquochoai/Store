import React from 'react';
import {FaCalendarDay} from "react-icons/fa";
import BlogItem from "./BlogItem.tsx";

const Blog = () => {
    return (
        <div className={'mx-[10%] mt-16'}>
          <div className={'flex justify-between items-center'}>
              <p className={'text-3xl font-bold'}>Our Recent Blog</p>
              <button className={'bg-green_primary p-2 rounded-[7px] text-white hover:bg-yellow-200 transition-all duration-300'}>View All</button>
          </div>
          <div className={'mt-8 grid grid-cols-3 gap-4'}>
              <BlogItem />
              <BlogItem />
              <BlogItem />
          </div>
        </div>
    );
};

export default Blog;