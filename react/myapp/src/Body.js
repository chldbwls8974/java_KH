import Pagination from './Pagination.js';
import Contents from './Contents.js';

function Body(){
    return(
        <div className="body">
            <div className="left-box">
                <Contents/>
                <Pagination/>
            </div>
            <div className="right-box"></div>
        </div>
    )
}

export default Body;