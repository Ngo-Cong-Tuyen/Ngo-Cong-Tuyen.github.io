const testimonials = [
    {
        name: "Nelson Mandela",
        quote: 'The greatest glory in living lies not in never falling, but in rising every time we fall',
        color: 'red',
    },
    {
        name: "Nelson Mandela2",
        quote: 'The greatest glory in living lies not in never falling, but in rising every time we fall',
        color: 'green',
    },
    {
        name: "Nelson Mandela3",
        quote: 'The greatest glory in living lies not in never falling, but in rising every time we fall',
        color: 'blue',
    },
    {
        name: "Nelson Mandela4",
        quote: 'The greatest glory in living lies not in never falling, but in rising every time we fall',
        color: 'red',
    },
    {
        name: "Nelson Mandela5" , 
        quote: 'The greatest glory in living lies not in never falling, but in rising every time we fall',
        color: 'red',
        },
]

const testimonialEl = document.querySelector('.testimonials-container');
const textEl = document.querySelector('.text');
const nameEl = document.querySelector('.name');
const authors = document.querySelectorAll('.author');

authors.forEach((author, index) =>{
    author.addEventListener('click', function()  {
        Array.from(authors).map(e => e.classList.remove('selected'));
        author.classList.add('selected');
        renderTestimonial(index);
    })

})

const renderTestimonial = index => {
    let testimonial = testimonials(index);
    let 
}