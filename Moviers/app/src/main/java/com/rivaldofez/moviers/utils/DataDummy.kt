package com.rivaldofez.moviers.utils

import com.rivaldofez.moviers.entity.MovieEntity
import com.rivaldofez.moviers.entity.TvShowEntity

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(
            id = 200,
            title = "Star Trek: Insurrection",
            date = "1998-12-11",
            overview = "When an alien race and factions within Starfleet attempt to take over a planet that has \\\"regenerative\\\" properties, it falls upon Captain Picard and the crew of the Enterprise to defend the planet's people as well as the very ideals upon which the Federation itself was founded.",
            rating = 4.5F,
            studio = "Paramount",
            posterPath = "https://image.tmdb.org/t/p/w500/jYtNUfMbU6DBbmd4LUS19u4hF4p.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/goNk0VDnUjxKjB6o69kYS5vvZo2.jpg"
        ))
        movies.add(MovieEntity(
            id = 700,
            title = "Octopussy",
            date = "1983-06-05",
            overview = "James Bond is sent to investigate after a fellow “00” agent is found dead with a priceless Fabergé egg. Bond follows the mystery and uncovers a smuggling scandal and a Russian General who wants to provoke a new World War.",
            rating = 4.0F,
            studio = "Metro-Goldwyn-Mayer",
            posterPath = "https://image.tmdb.org/t/p/w500/HORpg5CSkmeQlAolx3bKMrKgfi.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/aqvospM52NFtgFkrIbzk5nSy7Sh.jpg"
        ))
        movies.add(MovieEntity(
            id = 701,
            title = "Our Hospitality",
            date = "1923-11-19",
            overview = "A man returns to his Appalachian homestead. On the trip, he falls for a young woman. The only problem is her family has vowed to kill every member of his family.",
            rating = 3.4F,
            studio = "Joseph M. Schenck Productions",
            posterPath = "https://image.tmdb.org/t/p/w500/aUcEOlNYuSuYdtoanQxnxcGqmKO.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/4tbUsrndxsHcHsJE3jGNxVtlZj3.jpg"
        ))
        movies.add(MovieEntity(
            id = 600,
            title = "Full Metal Jacket",
            date = "1987-06-26",
            overview = "A pragmatic U.S. Marine observes the dehumanizing effects the U.S.-Vietnam War has on his fellow recruits from their brutal boot camp training to the bloody street fighting in Hue.",
            rating = 3.6F,
            studio = "Warner Bros. Pictures",
            posterPath = "https://image.tmdb.org/t/p/w500/kMKyx1k8hWWscYFnPbnxxN4Eqo4.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/7b5R8FfGUzlxfhOkPpL3xyIeuyF.jpg"
        ))
        movies.add(MovieEntity(
            id = 764,
            title = "The Evil Dead",
            date = "1981-09-10",
            overview = "When a group of college students finds a mysterious book and recording in the old wilderness cabin they've rented for the weekend, they unwittingly unleash a demonic force from the surrounding forest.",
            rating = 3.7F,
            studio = "Renaissance Pictures",
            posterPath = "https://image.tmdb.org/t/p/w500/uYxQ6xhP3WjqPZtxyAOnZQWnZqn.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/zGs5tZOlvc9cprdcU6kDOVNpujf.jpg"
        ))
        movies.add(MovieEntity(
            id = 567,
            title = "Rear Window",
            date = "1954-09-01",
            overview = "A wheelchair-bound photographer spies on his neighbors from his apartment window and becomes convinced one of them has committed murder.",
            rating = 3.0F,
            studio = "Alfred J. Hitchcock Productions",
            posterPath = "https://image.tmdb.org/t/p/w500/qitnZcLP7C9DLRuPpmvZ7GiEjJN.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/zGs5tZOlvc9cprdcU6kDOVNpujf.jpg"
        ))
        movies.add(MovieEntity(
            id = 673,
            title = "Harry Potter and the Prisoner of Azkaban",
            date = "2004-05-31",
            overview = "Year three at Hogwarts means new fun and challenges as Harry learns the delicate art of approaching a Hippogriff, transforming shape-shifting Boggarts into hilarity and even turning back time. But the term also brings danger: soul-sucking Dementors hover over the school, an ally of the accursed He-Who-Cannot-Be-Named lurks within the castle walls, and fearsome wizard Sirius Black escapes Azkaban. And Harry will confront them all.",
            rating = 4.9F,
            studio = "Warner Bros. Pictures",
            posterPath = "https://image.tmdb.org/t/p/w500/aWxwnYoe8p2d2fcxOqtvAtJ72Rw.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/kT8bDEAgEYBKhRJtqM97qTw6uRW.jpg"
        ))
        movies.add(MovieEntity(
            id = 671,
            title = "Harry Potter and the Philosopher's Stone",
            date = "2001-11-16",
            overview = "Harry Potter has lived under the stairs at his aunt and uncle's house his whole life. But on his 11th birthday, he learns he's a powerful wizard -- with a place waiting for him at the Hogwarts School of Witchcraft and Wizardry. As he learns to harness his newfound powers with the help of the school's kindly headmaster, Harry uncovers the truth about his parents' deaths -- and about the villain who's to blame.",
            rating = 4.5F,
            studio = "Warner Bros. Pictures",
            posterPath = "https://image.tmdb.org/t/p/w500/wuMc08IPKEatf9rnMNXvIDxqP4W.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500//hziiv14OpD73u9gAak4XDDfBKa2.jpg"
        ))
        movies.add(MovieEntity(
            id = 672,
            title = "Harry Potter and the Chamber of Secrets",
            date = "2002-11-13",
            overview = "Cars fly, trees fight back, and a mysterious house-elf comes to warn Harry Potter at the start of his second year at Hogwarts. Adventure and danger await when bloody writing on a wall announces: The Chamber Of Secrets Has Been Opened. To save Hogwarts will require all of Harry, Ron and Hermione’s magical abilities and courage.",
            rating = 4.8F,
            studio = "Warner Bros. Pictures",
            posterPath = "https://image.tmdb.org/t/p/w500/sdEOH0992YZ0QSxgXNIGLq1ToUi.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/8f9dnOtpArDrOMEylpSN9Sc6fuz.jp"
        ))
        movies.add(MovieEntity(
            id = 49018,
            title = "Insidious",
            date = "2010-09-13",
            overview = "A family discovers that dark spirits have invaded their home after their son inexplicably falls into an endless sleep. When they reach out to a professional for help, they learn things are a lot more personal than they thought.",
            rating = 4.7F,
            studio = "Blumhouse Productions",
            posterPath = "https://image.tmdb.org/t/p/w500/tmlDFIUpGRKiuWm9Ixc6CYDk4y0.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/bylGn5OC2h3BWfGLYFtIcxlYxLy.jpg"
        ))

        return movies
    }

    fun generateDummyTvShow() : List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(TvShowEntity(
            id = 1,
            title = "The Flash",
            date = "2014-10-07",
            overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            studio = "Warner Bros. Pictures",
            rating = 4.4F,
            status = "Complete",
            episode = 24,
            posterPath = "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/vEyQhPi2cjHamAsVClq3y14qtnv.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 2,
            title = "Lucifer",
            date = "2016-01-25",
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            studio = "Warner Bros. Pictures",
            rating = 4.5F,
            status = "Complete",
            episode = 24,
            posterPath = "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 3,
            title = "Supernatural",
            date = "2005-09-13",
            overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
            studio = "Warner Bros. Pictures",
            rating = 4.7F,
            status = "Complete",
            episode = 24,
            posterPath = "https://image.tmdb.org/t/p/w500/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/nVRyd8hlg0ZLxBn9RaI7mUMQLnz.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 4,
            title = "The Arrow",
            date = "2012-10-10",
            overview = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            studio = "Warner Bros. Pictures",
            rating = 4.8F,
            status = "Complete",
            episode = 24,
            posterPath = "https://image.tmdb.org/t/p/w500/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/vNnLAKmoczRlNarxyGrrw0KSOeX.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 5,
            title = "The Gifted",
            date = "2017-10-02",
            overview = "A suburban couple's ordinary lives are rocked by the sudden discovery that their children possess mutant powers. Forced to go on the run from a hostile government, the family joins up with an underground network of mutants and must fight to survive.",
            studio = "Marvel Studios, LLC",
            rating = 4.7F,
            status = "Complete",
            episode = 66,
            posterPath = "https://image.tmdb.org/t/p/w500/nshCqszjTNuqhrB53vrSqWO18sE.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/18inwHlpKnK9mt02wFBJoIVKXI.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 6,
            title = "Loki",
            date = "2021-06-09",
            overview = "The mercurial villain Loki resumes his role as the God of Mischief following the events of \\\"Avengers: Endgame\\\".",
            studio = "Marvel Studios, LLC",
            rating = 4.3F,
            status = "In Production",
            episode = 1,
            posterPath = "https://image.tmdb.org/t/p/w500/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 7,
            title = "The Falcon and the Winter Soldier",
            date = "2021-03-19",
            overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            studio = "Marvel Studios, LLC",
            rating = 4.0F,
            status = "In Production",
            episode = 1,
            posterPath = "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/dK4co8GHeZCybKOe6FB6eiBWxe9.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 8,
            title = "Marvel's Agent Carter",
            date = "2015-01-06",
            overview = "It's 1946, and peace has dealt Peggy Carter a serious blow as she finds herself marginalized when the men return home from fighting abroad. Working for the covert SSR (Strategic Scientific Reserve), Peggy must balance doing administrative work and going on secret missions for Howard Stark all while trying to navigate life as a single woman in America, in the wake of losing the love of her life - Steve Rogers.",
            studio = "Marvel Studios, LLC",
            rating = 3.7F,
            status = "Complete",
            episode = 34,
            posterPath = "https://image.tmdb.org/t/p/w500/7kqIsjjDMZA5GRMH5VCdQYZJqc6.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/yetJ3E392yKQaG5FkHsEN7xwUrM.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 9,
            title = "The Vampire Diaries",
            date = "2009-09-10",
            overview = "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
            studio = "Universal Studios",
            rating = 3.9F,
            status = "Complete",
            episode = 80,
            posterPath = "https://image.tmdb.org/t/p/w500/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/k7T9xRyzP41wBVNyNeLmh8Ch7gD.jpg"
        ))
        tvShows.add(TvShowEntity(
            id = 10,
            title = "The Originals",
            date = "2013-10-03",
            overview = "A spin-off from The Vampire Diaries and set in New Orleans, The Originals centers on the Mikaelson siblings, otherwise known as the world's original vampires: Klaus, Elijah, and Rebekah. Now Klaus must take down his protégé, Marcel, who is now in charge of New Orleans, in order to re-take his city, as he originally built New Orleans. Klaus departed from the city after being chased down by his father Mikael, while it was being constructed and Marcel took charge. As Klaus has returned after many years, his ego has provoked him to become the king of the city. \\\"Every King needs an heir\\\" says Klaus, accepting the unborn child. The child is a first to be born to a hybrid and a werewolf.",
            studio = "Universal Studios",
            rating = 4.7F,
            status = "Complete",
            episode = 77,
            posterPath = "https://image.tmdb.org/t/p/w500/2llbXc2BOkLkBGgcNJCRbrWedUO.jpg",
            backdropPath = "https://image.tmdb.org/t/p/w500/rH2QnJFNwSvUD82zS1syDIYNg9w.jpg"
        ))

        return tvShows
    }
}