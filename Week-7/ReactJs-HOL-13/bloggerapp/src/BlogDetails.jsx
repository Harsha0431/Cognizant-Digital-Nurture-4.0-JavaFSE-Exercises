
export default function BlogDetails(props) {
    return (
        <div>
            {
                props.blogs.map((blog) => <div key={blog.id}>
                    <h2>{blog.name}</h2>
                    <b>{blog.author}</b>
                    <p>{blog.desc}</p>
                </div>)
            }
        </div>
    )
}
