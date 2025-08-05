
export default function CourseDetails(props) {
    return (
        <div>
            {
                props.courses.map((course, index) => <div key={index}>
                    <h2>{course.title}</h2>
                    <b>{course.date}</b>
                </div>)
            }
        </div>
    )
}
