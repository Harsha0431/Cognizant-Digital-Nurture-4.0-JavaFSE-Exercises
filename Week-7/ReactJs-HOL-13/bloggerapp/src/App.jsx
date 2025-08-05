import './App.css'
import BlogDetails from './BlogDetails'
import BookDetails from './BookDetails'
import CourseDetails from './CourseDetails'

function App() {

  const data = {
    courses: [
      {
        title: 'Angular',
        date: '4/5/2021'
      },
      {
        title: 'React',
        date: '6/3/2021'
      }
    ],
    books: [
      {
        bname: 'Master React',
        id: 101,
        price: 670
      },
      {
        bname: 'Deep Dive into Angular 11',
        id: 102,
        price: 800
      },
      {
        bname: 'Mongo Essentials',
        id: 103,
        price: 450
      }
    ],
    blogs: [
      {
        name: 'React Learning',
        id: 101,
        author: "Stephen Biz",
        desc: 'Welcome to learning React!'
      },
      {
        name: 'Installation',
        id: 102,
        author: "Schewzdenier",
        desc: 'You can install React from npm.'
      }
    ]
  }

  return (
    <div className='container'>
      <div>
        <h1>
          Course Details
        </h1>
        <CourseDetails courses={data.courses} />
      </div>

      <div className='divider'></div>

      <div>
        <h1>
          Book Details
        </h1>
        <BookDetails books={data.books} />
      </div>

      <div className='divider'></div>

      <div>
        <h1>Blog Details</h1>
        <BlogDetails blogs={data.blogs} />
      </div>
    </div>
  )
}

export default App
