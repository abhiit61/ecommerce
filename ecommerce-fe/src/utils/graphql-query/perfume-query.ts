export const getAllPerfumesByQuery = `
    {
        perfumes {
            id
            productTitle
            productr
            price
            filename
            perfumeRating
        }
    }
`;

export const getPerfumeByQuery = (id: string) => `
    {
        perfume(id: ${id}) {
            id
            productTitle
            productr
            year
            country
            productGender
            fragranceTopNotes
            fragranceMiddleNotes
            fragranceBaseNotes
            filename
            price
            volume
            type
            perfumeRating
            reviews {
                id
                author
                message
                date
                rating
            }
        }
    }
`;

export const gePerfumesByIdsQuery = (ids: Array<number>) => `
    {
        perfumesIds(ids: [${ids}]) {
            id
            productTitle
            productr
            price
            filename
            perfumeRating
        }
    }
`;
