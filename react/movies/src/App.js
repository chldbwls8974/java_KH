import {BrowserRouter, Routes, Route, Link, useLocation, useNavigate} from 'react-router-dom'
import {useEffect, useState} from 'react'

function Header(){
	return(
		<header className='menu'>
			<ul className='menu-list'>
				<li className='menu-item'>
					<Link to="/" className='menu-link'>List</Link>
				</li>
				<li className='menu-item'>
					<Link to="/insert" className='menu-link'>Add New Movie</Link>
				</li>
			</ul>
		</header>
	)
}

function Home({list, deleteMovie, addMovie}){
	const location = useLocation();
	let movie = location.state;
	if(movie != null){
		addMovie(movie);
		location.state = null;
	}
	return (
		<main className='container'>
			<h1>Movies</h1>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Genre</th>
						<th>ReleaseDate</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					{list.length == 0 ?
						<tr><th colSpan={4}><h1>등록된 영화가 없습니다.</h1></th></tr> :
						list.map(item=>{
							return(
								<tr key={item.id}>
									<td>{item.id}</td>
									<td>{item.title}</td>
									<td>{item.genre}</td>
									<td>{item.release_date}</td>
									<td><button onClick={()=>{deleteMovie(item.id)}}>Delete</button></td>
								</tr>
							)
						})
					}
				</tbody>
			</table>
		</main>
	)
}


function Input({type,placeholder,onChange,value}){
	return(
		<input type={type} placeholder={placeholder} onChange={onChange} value={value} />
	)
}


function Insert({list}){
	const navigate = useNavigate();
	const [id, setId] = useState('');
	const [title, setTitle] = useState('');
	const [genre, setGenre] = useState('');
	const [release_date, setReleaseDate] = useState('');

	const idChange = e => setId(e.target.value);
	const titleChange = e => setTitle(e.target.value);
	const genreChange = e => setGenre(e.target.value);
	const dateChange = e => setReleaseDate(e.target.value);

	

	const insertMovie = ()=>{
		let count = 0;
		for(var key in list){
			if(list[key].id == id){
				++count;
			}
		}
		if(count==0){
			navigate('/',{
			state : {
				id : id,
				title : title,
				genre : genre,
				release_date : release_date
			}
		})
		}
		else{alert('중복된 아이디 입니다.')}
	}
	return (
		<div className='container'>
			<h1 className='maintitle'>Create Movie</h1>
			<Input type="text" placeholder='input movie id' onChange={idChange} value={id}  required />
			<br/>
			<Input type="text" placeholder='input movie title' onChange={titleChange} value={title}  required />
			<br/>
			<Input type="text" placeholder='input movie genre' onChange={genreChange} value={genre}  required />
			<br/>
			<span>출시일:</span>
			<Input type="date" placeholder='연도-월-일' onChange={dateChange} value={release_date}  required />
			<br/>
			<button onClick={insertMovie}>Add Movie</button>
		</div>


	)
}





function App() {
  let [list, setList] = useState([{
    id :1,
    title : 'Movie 1',
    genre : 'Drama',
    release_date : '2022-01-01'
  },{
    id :2,
    title : 'Movie 2',
    genre : 'Action',
    release_date : '2022-02-01'
  },{
    id :3,
    title : 'Movie 3',
    genre : 'Comedy',
    release_date : '2022-03-01'
  }]);
  const deleteMovie = (id)=>{
    let tmpList = list.filter(item=>item.id != id);
    setList(tmpList);
  }
  
  const addMovie = (movie)=>{
	setList([...list, movie]);
  }

  
  return (
    <div>
      <BrowserRouter>
        <Header/>
        <Routes>
          <Route path="/" exact element={<Home list={list} deleteMovie={deleteMovie} addMovie={addMovie} />} />
          <Route path='/insert' element={<Insert list={list}/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
