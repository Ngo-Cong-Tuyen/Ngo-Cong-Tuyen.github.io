-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: db
-- Thời gian đã tạo: Th8 05, 2022 lúc 12:57 PM
-- Phiên bản máy phục vụ: 8.0.30
-- Phiên bản PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db-blog`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog`
--

CREATE TABLE `blog` (
  `id` int NOT NULL,
  `content` text,
  `created_at` datetime DEFAULT NULL,
  `description` text,
  `published_at` datetime DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `blog`
--

INSERT INTO `blog` (`id`, `content`, `created_at`, `description`, `published_at`, `slug`, `status`, `thumbnail`, `title`, `updated_at`, `user_id`) VALUES
(3, 'Est odio dolor quibusdam nostrum qui ut error quod labore voluptatem voluptatem perspiciatis quis quis quod ea optio voluptatum ipsum non suscipit numquam nobis quis quisquam quas expedita in et id eum ipsa quas commodi nam exercitationem a ullam cupiditate consequatur rerum consectetur aliquid natus quia porro quasi laboriosam temporibus odio ad illum consequatur rerum fuga excepturi explicabo et iure reiciendis nihil amet a excepturi non perferendis quia quos quod delectus omnis architecto a aliquam iste omnis a quis rerum tempora qui eveniet sapiente quos facilis quibusdam illum et rerum recusandae voluptas error vel hic ipsa qui voluptatibus aut labore et et doloremque.', '2022-08-01 21:16:02', 'Quas quis id laboriosam aut magni perspiciatis commodi ut esse et dolorum eius porro temporibus molestiae sequi officia ut illo quia quia quia aut praesentium omnis natus pariatur explicabo animi non soluta ipsam et quia amet omnis est id et labore perferendis nostrum voluptatem maiores quaerat animi voluptas labore quod et voluptatem.', '2022-08-01 21:16:02', 'aut-atque-in-et-eum-et-autem-et-voluptatem-est-qui-vero', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 'Aut atque in et eum et autem et voluptatem est qui vero.', NULL, 9),
(4, 'Autem sequi id molestias perspiciatis nulla libero tenetur omnis consequatur sunt amet voluptatem debitis temporibus assumenda nihil impedit voluptas error veniam dolorem voluptatem expedita et non aperiam eaque autem laboriosam reiciendis quo in vel eligendi enim illo et tenetur facere dignissimos provident quod facere blanditiis molestias non et velit aut repudiandae sit fugit consectetur laboriosam ut omnis quos dolorem officiis sint numquam quia possimus aut facere et aliquam eos quia sed eligendi earum ad non quae molestias ullam sunt asperiores eligendi voluptatem nesciunt velit quaerat et iste dicta enim repellat voluptas ut maxime adipisci temporibus odio commodi dolores praesentium tempora maiores.', '2022-08-01 21:16:02', 'Accusamus aut aut ut ipsum occaecati accusantium ducimus voluptatibus autem qui voluptate corrupti et fugiat ea iusto vel nemo harum aspernatur et dolorem fugit aliquam sapiente quia qui id deleniti et commodi aut quia error sed ipsam dolorum ea sit eveniet doloribus deleniti esse autem est rerum sunt consequatur cupiditate.', '2022-08-01 21:16:02', 'suscipit-atque-doloremque-quia-inventore-et-omnis-quia-et-et-eaque-quod-architecto-accusantium', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 'Suscipit atque doloremque quia inventore et omnis quia et et eaque quod architecto accusantium.', NULL, 7),
(5, 'Quos nisi consequuntur sit quaerat aut earum odit doloribus accusamus facere vel ex dolor et animi iusto nisi modi voluptatem aut id id dolorem nemo et quam maxime nesciunt rem alias quia et sapiente possimus fuga ea quaerat non vitae nesciunt non architecto voluptatem mollitia vitae autem necessitatibus et ex sit ut aliquid voluptatem molestias et suscipit magnam libero aut fugiat quasi qui est dolorum dolore voluptatem sed non blanditiis eos facilis vel quia aut fuga et repudiandae sint sit qui voluptatibus expedita esse reprehenderit nesciunt voluptatem dolore saepe quam corporis quaerat sed amet quia ut voluptas et autem corrupti dolores.', '2022-08-01 21:16:02', 'Tempore in corporis et velit odit cum nam quasi suscipit quia numquam voluptates voluptate cumque ut sit doloremque ipsum molestiae ullam explicabo ratione fugiat incidunt est impedit molestiae distinctio atque omnis libero aspernatur alias ut natus debitis repellat eveniet provident qui et accusamus quis ad quia ratione necessitatibus nobis veniam quisquam impedit cum molestiae.', NULL, 'vitae-eos-ipsum-temporibus-quo-amet-non-quia-perspiciatis-deleniti-assumenda-eveniet-assumenda-soluta-a', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 'Vitae eos ipsum temporibus quo amet non quia perspiciatis deleniti assumenda eveniet assumenda soluta a.', NULL, 7),
(6, 'Doloribus voluptatibus non alias minus id quod ad voluptas quisquam exercitationem rerum aut et explicabo rerum ratione id et laboriosam id molestiae tempore consectetur quibusdam perspiciatis voluptate eveniet vero enim aspernatur dolorem consectetur eligendi laboriosam soluta sint maxime voluptate pariatur dolores ipsa nihil et molestias magni debitis ut error blanditiis adipisci explicabo qui officia sed quae ut provident accusantium incidunt modi non est possimus dolor facere labore aut consectetur reprehenderit ut magnam officiis ea distinctio earum voluptatibus tempore neque quis ullam tenetur et eaque tempora voluptates consequatur explicabo dolorum aliquid blanditiis pariatur tempore mollitia odio maxime similique ab omnis consequuntur quis quia.', '2022-08-01 21:16:02', 'Et numquam provident nam deleniti quia quod laboriosam cum saepe esse incidunt sed cupiditate ea id laudantium commodi doloremque sint minus quibusdam aliquam quo est fugiat iure veniam tempora quo quis est exercitationem est libero minima occaecati optio culpa soluta voluptas fuga perspiciatis est hic reprehenderit sequi ex incidunt eos minima quas fuga repellendus.', NULL, 'et-sunt-reprehenderit-illo-reprehenderit-quo-non-unde-sed-unde-et-totam-quaerat', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 'Et sunt reprehenderit illo reprehenderit quo non unde sed unde et totam quaerat.', NULL, 4),
(8, 'Aliquam nihil ullam fuga cupiditate ut vero expedita repellendus explicabo eveniet sint qui molestias velit autem reprehenderit explicabo in ea assumenda excepturi nobis natus explicabo earum aut consequatur reprehenderit sunt id cupiditate fugiat et eos dolorum saepe omnis quo aut aut amet ut et qui culpa odit rerum animi ut et neque repellendus laboriosam aut voluptas quo quo quod nesciunt porro nulla molestiae voluptatibus maiores reiciendis itaque magnam vel tempore fugiat aut voluptas vero odit explicabo laborum animi dolor qui id labore et impedit est dicta libero dolorem iusto sed aut dicta assumenda nemo dolor magnam animi ipsum qui sunt velit officia aperiam enim.', '2022-08-01 21:16:02', 'Nobis veritatis perspiciatis doloribus fugit quibusdam omnis reprehenderit nihil dolorem quisquam qui deserunt et aperiam velit accusantium impedit itaque et omnis dolorem magnam rerum et cupiditate ab quis dolore qui exercitationem aliquam maxime voluptatem quis maiores illo fuga quisquam pariatur sit autem iusto optio adipisci maxime et eveniet nihil eveniet.', '2022-08-01 21:16:02', 'aut-magnam-rerum-itaque-eius-quod-voluptatem-vitae-ipsa-perspiciatis-asperiores', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 'Aut magnam rerum itaque eius quod voluptatem vitae ipsa perspiciatis asperiores.', NULL, 6),
(9, 'Sed nulla aut aut voluptates quia quia est voluptatum quam inventore qui ut est quod assumenda officia dolor et recusandae exercitationem qui neque aspernatur fuga impedit suscipit sint velit dolores et reprehenderit quae aut similique ipsa repellendus omnis deleniti laudantium asperiores dicta ducimus expedita repudiandae doloremque nihil aliquid quidem consequatur officiis dolores corrupti perferendis nemo aut sit dolorum maxime qui ut perferendis enim sint distinctio alias beatae fugiat quis quos ipsam laboriosam blanditiis earum aut quia sint rerum voluptas cumque voluptas nesciunt in quo velit harum sequi nihil earum amet adipisci ea voluptatem unde eius quis exercitationem autem optio rerum similique.', '2022-08-01 21:16:03', 'Perferendis voluptatem sit repellendus sed debitis ab rerum non quasi et consectetur hic quia ea eius voluptatem sit et voluptate voluptas voluptatem eligendi aut vero veritatis recusandae voluptates quisquam omnis qui voluptatem vitae fuga ab sequi exercitationem officia voluptas quia perspiciatis quia debitis ut aut ab nesciunt officia cupiditate praesentium est nobis magnam.', NULL, 'ut-dolore-numquam-similique-sed-qui-numquam-dolores-ut-doloremque-voluptas-ut-perferendis-eveniet', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 'Ut dolore numquam similique sed qui numquam dolores ut doloremque voluptas ut perferendis eveniet.', NULL, 8),
(10, 'Mollitia cupiditate incidunt et et debitis et eum autem sapiente voluptatum nobis repellendus vitae enim aut ad quibusdam quibusdam cupiditate est neque aliquam sit voluptates quod sunt non fugiat aut pariatur occaecati quas est at voluptatibus mollitia eos aliquam unde officia error non qui consequatur placeat quos qui quas officia dolorem totam et qui ab id occaecati at omnis officia et vel praesentium sit quia natus beatae enim quis sit aut qui eos quia sint cumque beatae totam vero minus dolorem ab nam dolore et atque excepturi et impedit velit id assumenda soluta quia saepe molestiae maxime est consequatur eos quia consequatur vitae.', '2022-08-01 21:16:03', 'Sint dolore reiciendis corrupti eveniet esse dolorum voluptatum sed consequuntur beatae rerum dolor nemo ipsum similique voluptatum inventore porro consequatur delectus aut omnis qui placeat et at sit architecto fugit earum qui voluptatem saepe non corporis ipsum eius ex odio eos voluptatibus enim inventore sapiente ullam non et voluptatem vero.', NULL, 'facilis-consequatur-ipsum-ex-eveniet-sint-iure-et-magni-adipisci-assumenda', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 'Facilis consequatur ipsum ex eveniet sint iure et magni adipisci assumenda.', NULL, 3),
(11, 'Qui sequi non blanditiis tempore soluta tempore quibusdam necessitatibus iure itaque perspiciatis quis dolorem numquam corrupti fuga dignissimos vero magni necessitatibus quas adipisci deserunt veritatis iure voluptatem iure et autem eum distinctio voluptas consequuntur totam aut beatae deserunt nam consequatur nemo veritatis et similique odio rerum et eos tempora blanditiis fugiat impedit est qui est nulla sint rerum consequatur maxime delectus ab nesciunt ut libero error dolor explicabo quo id non atque natus sequi nobis rerum odit id blanditiis nostrum ea voluptatibus autem neque atque facilis tempora recusandae sed dolores expedita debitis ut voluptatibus omnis numquam nihil id alias esse fugit eveniet aperiam rerum.', '2022-08-01 21:16:03', 'Voluptas tempora soluta ut illo voluptas possimus dignissimos debitis rerum qui sint sed minima et qui nihil quia quia repellat et vel blanditiis harum magnam eligendi qui dolore tempora accusamus magni at voluptatem dolor aut vitae nemo fugit qui enim expedita sequi dolor sequi nulla dolores quas aperiam excepturi sed debitis quam nostrum deserunt quis.', NULL, 'non-dignissimos-ipsum-repellat-placeat-sint-commodi-necessitatibus-ex-voluptatem-eos-est-minus', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 'Non dignissimos ipsum repellat placeat sint commodi necessitatibus ex voluptatem eos est minus.', NULL, 5),
(12, 'Dolor sapiente pariatur id ullam vitae neque est aut quisquam minima architecto quos molestias in iste veritatis ut enim omnis est alias possimus eum eligendi iste ut voluptates repellat et autem sint facere necessitatibus magnam dolor incidunt magni placeat autem nobis hic ut dolor aspernatur explicabo sit sint quaerat perspiciatis impedit in ex quisquam nesciunt quis laboriosam laboriosam et aut id molestiae debitis non enim labore dolorum ea ipsum ratione est aut exercitationem unde veritatis sunt quos doloremque maxime veniam assumenda eum tempore ratione dolore voluptates assumenda magnam pariatur vero quaerat vel ullam libero id quasi quia et et aut.', '2022-08-01 21:16:03', 'Dignissimos quae molestiae exercitationem et optio velit voluptatem odio corporis natus sequi ipsa aliquid voluptas in nam velit consequatur excepturi nam odit blanditiis labore a quo natus perspiciatis cupiditate dolore eius ad error vitae repudiandae iste ut dicta facilis ullam facilis qui soluta similique eveniet dolores ea id hic qui.', NULL, 'eligendi-dolores-voluptas-rerum-dolorem-veniam-vel-cumque-voluptatem-sunt-qui-numquam-corrupti-qui-aliquid', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 'Eligendi dolores voluptas rerum dolorem veniam vel cumque voluptatem sunt qui numquam corrupti qui aliquid.', NULL, 7),
(13, 'Nemo eligendi possimus saepe aperiam totam et fugiat mollitia qui molestiae et ratione eveniet similique provident est qui consequatur nobis vero architecto architecto sed dolore saepe eaque enim blanditiis ipsam ad velit rerum et dolores commodi ipsa accusantium cumque aperiam voluptatem ex et modi in et excepturi voluptatem et est delectus iste et rem recusandae culpa similique voluptatum esse hic atque sint qui occaecati consequatur id et dicta explicabo repellat culpa esse facere ut ea doloremque aut dignissimos quia odit eligendi aperiam sed eius ut omnis quas modi qui dicta iure unde nobis beatae dicta aut aliquid autem in impedit aut aut sed rerum.', '2022-08-01 21:16:03', 'Impedit nihil qui porro omnis alias libero voluptates omnis qui tempore dolore dolorem saepe et id nulla aperiam id ipsam sequi et debitis quasi et rem ea voluptate facilis nesciunt eaque explicabo est illum odit qui laboriosam fugiat magni rerum debitis velit sequi error quo sequi itaque accusantium in dolore.', '2022-08-01 21:16:03', 'nihil-eius-laudantium-voluptates-aut-delectus-nostrum-eum-sit-in-ipsa', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 'Nihil eius laudantium voluptates aut delectus nostrum eum sit in ipsa.', NULL, 9),
(14, 'Eveniet neque omnis nobis est officiis reprehenderit molestiae sit nesciunt magnam vitae itaque possimus sint et qui rem alias quia neque fugit voluptates vitae pariatur nostrum sequi blanditiis aspernatur doloremque labore eum aut eveniet dicta hic nam tempora hic occaecati est nulla blanditiis doloremque odit necessitatibus non aut enim magnam et porro magni temporibus maiores in quos recusandae impedit quia laboriosam cum vitae non aut consequatur unde ad aut dolores vel alias explicabo natus sed aut quidem iusto illum enim est omnis deleniti ullam laboriosam ipsam totam aut voluptatibus rerum consequatur dolore neque amet non et necessitatibus adipisci aspernatur sit et.', '2022-08-01 21:16:03', 'Voluptatem ab minus repellendus nostrum dolor minus nihil illo blanditiis magnam omnis sunt et possimus repudiandae ut aut quia saepe quisquam sapiente id illum voluptatem qui repellat iusto nostrum dolore fugit animi inventore fugit incidunt inventore est est doloremque cum omnis vel eius incidunt distinctio sint fuga omnis qui accusantium molestiae.', NULL, 'accusantium-maxime-aut-ipsam-saepe-corrupti-eos-dignissimos-quo-inventore-sit-impedit-molestiae', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 'Accusantium maxime aut ipsam saepe corrupti eos dignissimos quo inventore sit impedit molestiae.', NULL, 3),
(15, 'Distinctio aut in nostrum omnis nemo ex adipisci cumque sint et illum modi itaque et voluptas mollitia non omnis est assumenda animi omnis quidem et qui totam et voluptatem esse et aliquam aperiam optio impedit omnis praesentium soluta quis quasi dolorem quisquam ut doloremque nihil veritatis accusamus qui autem iusto a impedit unde ipsa porro perferendis in ad magnam est aut inventore laudantium exercitationem incidunt nisi nemo officiis maiores aspernatur enim amet odio necessitatibus nobis inventore dolorem natus eos magnam porro reprehenderit minus molestiae quo adipisci magni enim sapiente amet et delectus rem distinctio consequatur molestias quia quos officia laboriosam ea reprehenderit aliquam dolores.', '2022-08-01 21:16:03', 'Ratione quia quo amet laudantium in possimus optio voluptatibus ut et illo in et facere ex facere soluta voluptatem exercitationem in minima molestiae vel voluptas blanditiis cupiditate autem quam fuga aspernatur aut animi et cupiditate magnam enim voluptatum autem aut corporis qui quasi unde fugit omnis omnis in totam cumque.', NULL, 'quibusdam-aliquam-autem-consectetur-et-numquam-vel-sint-recusandae-qui-autem-ipsa-ab-temporibus', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Quibusdam aliquam autem consectetur et numquam vel sint recusandae qui autem ipsa ab temporibus.', NULL, 7),
(16, 'Eum et laboriosam molestiae nihil vel omnis ut eius voluptatem adipisci rerum vero et repudiandae ipsum ea iste sit eaque culpa vel nihil voluptatem velit reprehenderit sunt dolorum ipsum nulla nostrum sint ratione eligendi sint in magni repellendus ducimus quas itaque et optio voluptas sit qui dolorum iure incidunt dolor magnam blanditiis ducimus facilis dolorem omnis qui ratione ut ullam optio hic at voluptatem ex dolorem commodi et molestiae veniam est dolorem nesciunt in cum delectus facere aliquam voluptatem quod maxime blanditiis qui fugit occaecati qui incidunt unde nam cumque est maiores laudantium consequuntur earum repudiandae temporibus ducimus et tempore in fugit.', '2022-08-01 21:16:03', 'Ullam adipisci nisi modi tenetur quod rerum expedita dolores facere incidunt eos debitis sunt ut atque dignissimos harum et laborum aperiam sequi porro quidem molestiae eum saepe qui velit quo tenetur a et iusto suscipit eos autem quae suscipit id quos cumque enim recusandae consectetur illo voluptatem reprehenderit magnam facilis.', NULL, 'ad-laborum-provident-quam-et-labore-non-assumenda-earum-neque-commodi-cumque-vero', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 'Ad laborum provident quam et labore non assumenda earum neque commodi cumque vero.', NULL, 5),
(17, 'Odio et aliquam laborum aut reiciendis quod assumenda non quam ipsum et est quia provident rerum repudiandae porro dolor repudiandae ratione amet quo ea ipsum architecto eaque natus est in ipsa et dicta incidunt sint enim consectetur qui et impedit dolores vitae vitae ut reprehenderit incidunt rem recusandae et nobis rerum esse placeat repudiandae qui eaque et eligendi fuga sit minima consequatur non autem architecto voluptatem dolorem consequatur in at voluptatem nam assumenda quod commodi officiis distinctio laudantium sed est aspernatur voluptatibus quasi eum quo minima quis est ea harum labore aut voluptatem dicta est exercitationem error sed dolor ad eum quidem.', '2022-08-01 21:16:03', 'Et omnis ducimus enim eum dolorum qui aut dolores dicta quod sit consectetur consequatur quae repellendus dolores illum deserunt aliquam pariatur pariatur occaecati ducimus necessitatibus consequatur repudiandae ad aut et sequi minima quam autem eos ex sapiente neque vel nobis libero autem et aut neque dolor commodi labore laborum voluptatem non.', '2022-08-01 21:16:03', 'unde-sapiente-id-corporis-expedita-aut-qui-cumque-voluptatem-repellat-qui-dolore-molestias-harum', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Unde sapiente id corporis expedita aut qui cumque voluptatem repellat qui dolore molestias harum.', NULL, 6),
(18, 'Aspernatur ut eum velit neque magnam at laudantium quis quis totam in cum nostrum voluptas expedita qui ipsa dolorum sed nemo occaecati eligendi a cumque nihil et aut rerum ducimus quasi sapiente facere suscipit omnis et sint accusamus dolor iste aspernatur harum distinctio excepturi saepe quis quasi ex voluptatem quia ut et assumenda et ab sed consequatur corrupti dolores error necessitatibus sed delectus provident veritatis aut rerum soluta qui similique sit et qui illo eos qui voluptatibus exercitationem illum est dicta fugit tenetur et molestiae cupiditate nostrum sit ut eum vero nostrum recusandae temporibus aliquid autem nihil culpa quod voluptatum impedit et.', '2022-08-01 21:16:03', 'Temporibus fugiat quia quas qui harum qui eum omnis ullam illum maxime eos voluptatum rerum qui ad magni quo incidunt tempore dolorum cupiditate pariatur harum ut veniam voluptatum aut temporibus velit ut dolore dicta quos a optio possimus eos repellat aut fugit quis error quod voluptas et repellendus harum harum velit architecto.', '2022-08-01 21:16:03', 'voluptas-occaecati-veniam-nisi-rem-voluptas-ad-maiores-nihil-at-voluptatem-minima-iure-modi-nulla', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Voluptas occaecati veniam nisi rem voluptas ad maiores nihil at voluptatem minima iure modi nulla.', NULL, 9),
(19, 'Esse eos tenetur officiis impedit velit vero eveniet cum sit nemo soluta facere harum modi consectetur doloremque perferendis ex et corrupti vitae sint reiciendis est consequatur maiores rerum placeat impedit modi numquam eius aliquam vitae sint voluptatem provident beatae qui commodi dolorem et blanditiis possimus tempore sed odit sapiente omnis sint non aperiam tenetur placeat dignissimos iste temporibus voluptatibus voluptatem aut quaerat ut quia et est eius voluptatem sunt atque et qui adipisci aliquid dolorem voluptatem qui corporis id voluptatum sit labore quam ratione numquam nostrum corporis et earum ut quod autem et quod impedit ad aliquam accusantium optio numquam et voluptates eveniet et qui.', '2022-08-01 21:16:03', 'Molestias dolor dolor natus rerum voluptatem eum voluptas nisi earum aut incidunt nihil architecto est et et quasi repellendus dolorem ratione aperiam error molestiae officiis sapiente reiciendis earum accusantium atque libero exercitationem qui repudiandae illo cupiditate velit et deleniti modi tempore minima quibusdam aut mollitia quis qui et eum ea.', '2022-08-01 21:16:03', 'velit-libero-necessitatibus-ut-dolore-molestiae-dolorem-officia-sit-accusantium-ullam-vero', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Velit libero necessitatibus ut dolore molestiae dolorem officia sit accusantium ullam vero.', NULL, 8),
(20, 'Animi qui non eveniet voluptatibus quae quaerat veniam aut sit corporis rerum ut mollitia doloremque et dolor saepe numquam harum temporibus et non explicabo molestias cumque qui fuga dicta tenetur quas expedita harum quia occaecati vero ab et velit est suscipit culpa eaque voluptatum quia cupiditate temporibus consequuntur ut ut quae et consequuntur veritatis blanditiis et et explicabo asperiores delectus adipisci recusandae repellat fuga reprehenderit eius illo nobis quibusdam debitis libero modi sed aut corporis quibusdam voluptatem corrupti maxime similique nam ut atque quia ab cum voluptates non consequatur incidunt maiores doloribus in quisquam aut culpa esse ex molestiae accusamus et quia minima.', '2022-08-01 21:16:04', 'Esse dolor molestias repellendus dolorum magni suscipit et sunt doloremque impedit sunt similique vel id qui modi cum aut quis consequatur qui error modi dolores iusto libero doloribus eligendi et voluptate incidunt dolorum sapiente repudiandae quasi asperiores soluta earum dolores distinctio omnis nisi explicabo molestiae similique officia error magnam nobis neque sed facilis.', '2022-08-01 21:16:04', 'aut-ut-qui-amet-molestias-aliquid-natus-amet-eum-aliquid', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 'Aut ut qui amet molestias aliquid natus amet eum aliquid.', NULL, 10),
(21, 'Similique iusto autem vero atque commodi quaerat non iusto iste deserunt saepe itaque magnam facilis sunt quia ut eaque et dolor autem excepturi est necessitatibus maiores unde amet ut laudantium explicabo officia aperiam excepturi dignissimos sed omnis similique perspiciatis et ut impedit rerum ad excepturi sit nisi ab laborum sit aliquam quia et omnis assumenda odio qui earum est saepe quia ipsa quas reiciendis corrupti officia quasi amet quas voluptas in dignissimos possimus quis ipsa architecto architecto enim delectus id autem qui voluptatibus totam illum error maiores voluptatibus ut deserunt est possimus ut aut distinctio est rerum dolor reiciendis voluptas sunt ut sed maxime tempora.', '2022-08-01 21:16:04', 'Porro saepe excepturi nemo magni exercitationem explicabo quibusdam voluptatem quibusdam ullam quisquam eligendi voluptate vel necessitatibus quas voluptas vero repellat molestias et quas omnis fugit doloremque mollitia qui eveniet et ducimus est unde dolor laudantium est quia reprehenderit fugit omnis occaecati quibusdam nulla dignissimos explicabo non corrupti necessitatibus fuga voluptates quia doloribus beatae.', NULL, 'cumque-molestiae-enim-similique-porro-voluptatem-alias-perspiciatis-eos-rerum', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Cumque molestiae enim similique porro voluptatem alias perspiciatis eos rerum.', NULL, 1),
(22, 'Odio laboriosam corporis totam corporis vitae aut aut repellendus et aut omnis ducimus eligendi dignissimos aut sint quia eaque quo sunt quaerat dolorem aut quibusdam libero illo numquam debitis repellendus maxime sequi et officiis maiores et adipisci dolorem qui ut minus numquam ullam sed consequatur veniam necessitatibus consequatur nisi non neque qui adipisci et eum repellendus eos eos explicabo veniam sint voluptatem nihil ut quis magni animi ullam nam ab illo provident aut voluptatem iure magni eum corporis nesciunt ipsa distinctio nobis in atque numquam esse eum quaerat quasi rerum nostrum at id non suscipit eveniet voluptate voluptatem error exercitationem dolor sed nisi quos.', '2022-08-01 21:16:04', 'Voluptatem consectetur modi dicta error suscipit saepe et accusantium dolorem eligendi vel dolorem dolores voluptas dicta quia nulla soluta ab et sit consequatur est atque architecto sit suscipit placeat aut ut ducimus modi sapiente nihil optio nobis et saepe illo ut odio odio quis fuga ea voluptatibus quia sit animi.', NULL, 'ea-vel-cumque-ad-harum-voluptate-architecto-dicta-sed-dicta-accusamus-quibusdam-enim-animi', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 'Ea vel cumque ad harum voluptate architecto dicta sed dicta accusamus quibusdam enim animi.', NULL, 1),
(23, 'Consequatur aliquid quia temporibus et at occaecati culpa vitae ipsa rem dolorum dolorem doloribus expedita quia ut voluptas harum quo qui et eos fugiat aut occaecati commodi id quia et aut quod vero aut dolores et reprehenderit autem qui et facilis possimus vero quos quasi odit aut ipsa quia error fugit sit qui distinctio ut nobis impedit ut et ut harum eum unde quas blanditiis dolorem non perferendis ut architecto cumque omnis dignissimos quaerat omnis aut voluptatem labore minus ratione ut qui dignissimos animi velit reprehenderit aut eius dolores ipsam qui et corporis ut ipsam consequatur dolor doloremque quia ea assumenda veritatis aut aut eius.', '2022-08-01 21:16:04', 'Sequi aperiam id numquam qui natus iusto consequatur ut architecto aspernatur quod accusamus illo voluptatem illum natus unde sit explicabo quibusdam vero nulla et et eos magnam officia quibusdam cupiditate ducimus ut quidem nihil nam dolorem ut tenetur quam omnis qui distinctio numquam sed maiores unde qui quaerat recusandae incidunt ipsam neque quisquam recusandae.', NULL, 'odit-quibusdam-eius-pariatur-ducimus-eum-cumque-sit-numquam-tempora-est-ab', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 'Odit quibusdam eius pariatur ducimus eum cumque sit numquam tempora est ab.', NULL, 10),
(24, 'Repellendus a quia rerum atque aut dolorem explicabo veniam ipsum maxime sunt voluptatem aliquam et aut non omnis cumque facilis eveniet eos illum et natus id voluptas aut voluptatem dolorum consequatur quae velit modi unde occaecati et est ut eligendi possimus vel cum ut illum placeat voluptas saepe deserunt dolores enim facilis nam dolores et voluptatum omnis consequatur dignissimos maiores nam iure eos assumenda est vel alias consequuntur debitis inventore quia fugiat quas dolorem est non saepe animi doloribus eveniet rerum quis enim est quod voluptates quia omnis accusamus necessitatibus et rerum temporibus dignissimos fugit eos qui nesciunt voluptatem et consequatur.', '2022-08-01 21:16:04', 'Sed qui rem dolor aut natus animi ab nihil tempora dicta quia omnis voluptates esse ut eum impedit adipisci sequi aut minima iste labore nulla dolorum qui similique eum a iure doloribus voluptatem saepe ex vel placeat reiciendis dolor quisquam autem quia molestias repellendus quis voluptas fugiat mollitia provident et ipsa labore omnis fuga.', '2022-08-01 21:16:04', 'alias-sapiente-omnis-non-pariatur-exercitationem-incidunt-quo-voluptatum-est-et-at-et-itaque', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Alias sapiente omnis non pariatur exercitationem incidunt quo voluptatum est et at et itaque.', NULL, 5),
(25, 'Quam eum ipsam illo iusto cupiditate error nisi ex sit asperiores illo esse explicabo qui inventore qui quia eius facilis mollitia quia ipsa iusto accusamus voluptatibus quaerat ut et dolorem repellat velit et eos nesciunt et cumque odit eius et distinctio numquam molestiae est dolore eveniet quibusdam velit excepturi quod nemo dolore eveniet ipsum minus dignissimos illo quis ratione dicta molestiae vitae pariatur qui quo adipisci possimus amet eos quos voluptatem qui praesentium dolores rerum non sint et ut quaerat ex omnis quisquam sed inventore esse tenetur quos eligendi illo a aliquam quaerat provident numquam vero ex voluptatem impedit rem non odio consequatur facilis.', '2022-08-01 21:16:04', 'Dolor quia iusto iste adipisci optio minima quae quia nulla in nesciunt earum ut magni sed illum quidem facere error qui tempore dicta nobis nam enim laboriosam non voluptas et consequuntur facere vero necessitatibus corporis accusamus veniam aliquid ipsa officia magnam aperiam sint distinctio nesciunt earum fugiat rerum voluptatem repellat quo voluptas dignissimos illum.', '2022-08-01 21:16:04', 'eligendi-necessitatibus-quam-iure-autem-eum-nam-neque-debitis-eius', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 'Eligendi necessitatibus quam iure autem eum nam neque debitis eius.', NULL, 10),
(26, 'Sint omnis culpa veritatis sint corporis impedit illum dignissimos omnis aut sint et nulla in mollitia est necessitatibus excepturi assumenda eum non totam et dolores dolores quo in dicta ducimus neque vel sit dicta architecto perferendis omnis non voluptas voluptatum iste voluptatem error beatae deleniti dolores et sunt alias temporibus minima a ducimus similique id optio alias ratione ut perspiciatis non velit quis commodi molestiae tenetur blanditiis et est labore eos minima inventore ex eveniet voluptatem perspiciatis dolore distinctio nisi enim voluptatem omnis mollitia optio omnis aut non aperiam voluptatum at eius vero sit aut quod eum dolorum expedita aut tempore ducimus.', '2022-08-01 21:16:04', 'Dolorum dolorem inventore quis nisi illo id dolorem error voluptatem consequatur nemo ipsa rerum cumque quia vel voluptatem eum et dicta doloremque et ut enim iste deleniti amet iusto molestias dolores quasi minus minus esse libero voluptatem odio animi eos distinctio qui iste dolore sunt occaecati exercitationem et consequatur eaque.', '2022-08-01 21:16:04', 'nihil-molestiae-nisi-harum-deleniti-ea-ipsa-est-sed-fugiat-sit', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 'Nihil molestiae nisi harum deleniti ea ipsa est sed fugiat sit.', NULL, 3),
(27, 'Aut quae aut sit sint rerum nesciunt hic consequuntur voluptatum dolor numquam dolores blanditiis quod quis deserunt voluptatem a consequatur minus velit perspiciatis quidem sapiente et inventore qui nulla quidem unde rem voluptas ea sit perspiciatis amet perferendis et voluptate ut id hic nulla sit unde quo quia vero dicta et ab provident rerum velit magni eos voluptate in eligendi harum deleniti dolores aut ullam illum ratione est rerum illum labore aliquam reiciendis facere ut iusto sint natus quidem velit amet nihil voluptatem autem sequi et officia exercitationem qui illum ab itaque expedita cum eos quia aut quisquam est quam autem corrupti rerum illum.', '2022-08-01 21:16:04', 'Ut rerum vel cupiditate repellat veniam odio modi aliquam nobis corrupti explicabo repellendus quaerat voluptatum occaecati adipisci aspernatur qui nostrum et ea sed dolor veniam voluptate nobis natus et id non qui omnis quaerat adipisci dolore id dolores optio tenetur est nihil vitae deleniti et vero ullam autem ut labore sunt illo.', NULL, 'corrupti-officia-sit-voluptatem-esse-sed-occaecati-voluptatem-accusantium-quia', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 'Corrupti officia sit voluptatem esse sed occaecati voluptatem accusantium quia.', NULL, 7),
(28, 'Quam similique adipisci qui sint quaerat voluptatem at sint iusto ducimus corrupti voluptate aliquam quo nostrum consectetur maiores molestias earum saepe sunt et ad voluptatem asperiores nam pariatur est atque placeat maxime eaque corrupti necessitatibus sint itaque impedit blanditiis blanditiis corrupti enim voluptas repudiandae eum commodi iusto minus cumque voluptatibus aut voluptatem sint omnis ducimus eius fugiat aut incidunt tempore aut quia quasi asperiores veniam distinctio ad sapiente beatae voluptas ut dolor velit ut assumenda aut ut reiciendis minus excepturi optio earum ex eum maxime totam illum aperiam laboriosam consequatur rerum non ut praesentium quas rerum omnis omnis et illo qui praesentium sit.', '2022-08-01 21:16:04', 'Ut eos quisquam est eius laboriosam et consequatur nobis ipsam iusto ratione eaque voluptatem et sit qui quibusdam nihil aut earum dolorum cum illo consequuntur amet sit perferendis aperiam sit fugiat voluptatum dolorem rerum dolor assumenda molestias excepturi voluptatem facere delectus officia omnis dolores officiis ullam id alias maiores doloremque sit harum optio voluptas.', NULL, 'in-expedita-nostrum-facilis-aut-quae-quidem-harum-autem-architecto-temporibus-quas-distinctio-expedita', 0, 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 'In expedita nostrum facilis aut quae quidem harum autem architecto temporibus quas distinctio expedita.', NULL, 8),
(29, 'Est eum nesciunt consequatur odio et provident velit non vero tempore sint saepe enim quia quod esse quo assumenda nesciunt sequi distinctio ut quia sapiente debitis eos fuga id vitae ex quo sit aliquid veritatis ipsam et tempore ullam ut velit repellat culpa iste ipsam alias eos consectetur rerum omnis nemo ad qui illo officia et vel consectetur velit in assumenda deserunt tempore eos ut neque nihil adipisci laborum quia nemo veniam ipsum ratione qui voluptatum nulla distinctio veniam aut molestiae dolores occaecati placeat voluptatum deserunt libero laudantium est quisquam corrupti ut voluptas assumenda dicta culpa sit harum hic consequuntur est.', '2022-08-01 21:16:04', 'Repellat id qui exercitationem vitae placeat tempora quis ea enim nisi neque ad omnis eveniet enim ut accusantium excepturi totam enim aperiam aut accusamus porro quidem totam quis libero asperiores quia pariatur laborum quisquam ullam facilis non occaecati qui at facilis omnis delectus accusantium est nobis pariatur cupiditate reprehenderit aut laborum autem.', '2022-08-01 21:16:04', 'et-sit-vitae-culpa-inventore-ipsum-sit-et-magni-cum-est-sequi-et-autem-aut', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 'Et sit vitae culpa inventore ipsum sit et magni cum est sequi et autem aut.', NULL, 6),
(30, 'Distinctio sed velit officiis voluptates odio animi et adipisci qui explicabo asperiores voluptas in corporis porro facilis doloribus est modi quos dolores et soluta earum similique officia est aut vel fugiat soluta temporibus ipsa provident quasi nemo ea sapiente cupiditate aut ut quia dicta nostrum sit quis et voluptas nesciunt porro voluptatum quisquam quaerat ut cupiditate nemo nulla odit molestias consequuntur nobis qui quasi sint suscipit quia dolores et provident optio rerum perferendis quis numquam amet animi ad quae consequuntur magni quo et tenetur accusantium dolor cum qui et esse deleniti quia unde consectetur sed minus architecto et excepturi magnam quos velit.', '2022-08-01 21:16:04', 'Quae ipsum voluptate sed in eum eum quia voluptas autem quasi tempora cumque sed velit velit doloremque qui quia enim ut asperiores explicabo sit molestias quas iure qui ut excepturi atque quis eligendi aut blanditiis enim sequi beatae earum omnis assumenda voluptas in et non est harum tempore aliquam explicabo deleniti et laboriosam alias.', '2022-08-01 21:16:04', 'et-molestiae-voluptas-laudantium-deleniti-laboriosam-quae-iusto-sit-ut', 1, 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 'Et molestiae voluptas laudantium deleniti laboriosam quae iusto sit ut.', NULL, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog_categories`
--

CREATE TABLE `blog_categories` (
  `blog_id` int NOT NULL,
  `categories_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `blog_categories`
--

INSERT INTO `blog_categories` (`blog_id`, `categories_id`) VALUES
(3, 4),
(3, 2),
(4, 8),
(4, 5),
(4, 4),
(5, 7),
(5, 8),
(5, 5),
(6, 1),
(6, 2),
(6, 10),
(8, 10),
(9, 5),
(9, 4),
(9, 9),
(10, 5),
(10, 6),
(11, 2),
(11, 5),
(11, 1),
(12, 6),
(12, 1),
(12, 4),
(13, 5),
(13, 10),
(14, 6),
(14, 3),
(14, 1),
(15, 9),
(15, 2),
(15, 7),
(16, 7),
(16, 8),
(16, 6),
(17, 6),
(17, 2),
(17, 10),
(18, 6),
(18, 1),
(18, 4),
(19, 1),
(19, 5),
(19, 8),
(20, 10),
(20, 8),
(20, 2),
(21, 1),
(21, 2),
(21, 8),
(22, 4),
(22, 7),
(22, 3),
(23, 10),
(23, 3),
(23, 7),
(24, 2),
(24, 10),
(24, 6),
(25, 7),
(25, 2),
(26, 3),
(26, 1),
(26, 7),
(27, 4),
(27, 3),
(27, 7),
(28, 5),
(28, 3),
(28, 8),
(29, 7),
(29, 6),
(29, 5),
(30, 4),
(30, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Xerath'),
(2, 'Gangplank'),
(3, 'Katarina'),
(4, 'Corki'),
(5, 'Mordekaiser'),
(6, 'Amumu'),
(7, 'Nocturne'),
(8, 'Elise'),
(9, 'LeBlanc'),
(10, 'Corki');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `id` int NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `blog_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `comment`
--

INSERT INTO `comment` (`id`, `content`, `created_at`, `updated_at`, `blog_id`, `user_id`) VALUES
(1, 'Laborum voluptatem dolores eum sed tempore id ut commodi quisquam eos quia nulla cupiditate vero quia quis totam reiciendis molestias.', '2022-08-01 21:16:11', NULL, 10, 3),
(2, 'Neque cumque consequatur delectus cum voluptas autem et vel quia ex perferendis aspernatur voluptatem laudantium porro error dicta qui recusandae recusandae sapiente optio quia voluptatem.', '2022-08-01 21:16:11', NULL, 14, 2),
(3, 'Rerum nisi debitis quas sapiente mollitia distinctio nobis in necessitatibus rem laudantium reprehenderit sunt esse sit maiores adipisci voluptas ipsam odio inventore culpa sequi reiciendis.', '2022-08-01 21:16:11', NULL, 11, 10),
(4, 'Rerum dolores perspiciatis et nulla consequatur eum et cumque eos voluptas facilis et consectetur numquam aspernatur et tempora explicabo ipsa in asperiores sit.', '2022-08-01 21:16:11', NULL, 17, 6),
(6, 'Laborum voluptatibus consequatur aut deserunt corrupti fugiat et laborum aut nisi distinctio repellendus illo eos accusantium aut laudantium architecto quis ratione possimus.', '2022-08-01 21:16:11', NULL, 25, 3),
(8, 'Aliquid quia quaerat harum aut laborum mollitia rerum odit ab iure rerum nihil et et dolor itaque perferendis odio qui sunt exercitationem.', '2022-08-01 21:16:11', NULL, 5, 9),
(9, 'Voluptates quod quae velit officia vero facere doloremque non est et amet velit omnis et vero eligendi ullam nostrum maxime soluta velit eos incidunt voluptatem.', '2022-08-01 21:16:11', NULL, 30, 6),
(10, 'Voluptatem minima earum dicta esse et hic pariatur repellendus ut consectetur velit rerum cum repellendus non voluptate ut itaque asperiores dolor voluptas ex accusamus hic.', '2022-08-01 21:16:11', NULL, 12, 8),
(11, 'Vel consequatur accusantium assumenda rerum voluptatum quaerat et maxime cumque vero omnis exercitationem iste perspiciatis ipsa eum autem labore non.', '2022-08-01 21:16:11', NULL, 26, 6),
(12, 'Explicabo perferendis ut ut harum quasi beatae qui beatae esse necessitatibus nisi fuga vel soluta quo deleniti eligendi placeat voluptatum non.', '2022-08-01 21:16:11', NULL, 5, 2),
(13, 'Odio accusamus aspernatur eum omnis eos in totam animi vitae consectetur quos eligendi dolores unde velit iste minima nihil quam magnam consequuntur officiis non et.', '2022-08-01 21:16:11', NULL, 23, 8),
(14, 'Praesentium velit officiis quod assumenda molestiae autem suscipit laboriosam dicta alias rerum suscipit eveniet asperiores quia nihil consequatur quia voluptate qui non velit.', '2022-08-01 21:16:11', NULL, 6, 1),
(15, 'Et quia exercitationem nemo atque numquam id veritatis qui praesentium dolorum est qui qui culpa corporis dolorem quia harum dolorem id deserunt et qui.', '2022-08-01 21:16:11', NULL, 16, 8),
(16, 'Qui corrupti quis ut nihil qui esse officia illo et fuga sapiente amet quibusdam necessitatibus aliquid blanditiis sint quia perspiciatis omnis quis velit aut ullam.', '2022-08-01 21:16:11', NULL, 8, 6),
(17, 'Nesciunt dicta voluptates non facilis quis nobis fuga necessitatibus necessitatibus quas accusamus sunt enim ea cumque natus numquam aut id amet autem omnis.', '2022-08-01 21:16:11', NULL, 17, 2),
(18, 'Expedita omnis ut labore temporibus enim quos est iusto ut eveniet voluptas recusandae ipsum dicta aperiam doloremque consequatur est hic blanditiis architecto sit perspiciatis.', '2022-08-01 21:16:11', NULL, 12, 2),
(19, 'Eum ea facere quis unde aut similique inventore explicabo consequuntur et maxime aut alias quidem qui dolorem alias natus libero rerum impedit.', '2022-08-01 21:16:12', NULL, 16, 3),
(20, 'Modi natus quia illo tempora delectus nihil eum laborum natus blanditiis excepturi itaque eos dolor suscipit sint commodi debitis aperiam debitis sit.', '2022-08-01 21:16:12', NULL, 24, 8),
(21, 'Minima fugit quia error deleniti doloribus sed consequatur aut consectetur quisquam voluptatem eos quo ipsa tempore ut doloribus velit blanditiis praesentium.', '2022-08-01 21:16:12', NULL, 8, 2),
(22, 'Repellendus neque autem unde illo quasi aut ullam quaerat quia sint culpa animi consectetur rerum aut deleniti et vel voluptas ut rerum eos.', '2022-08-01 21:16:12', NULL, 12, 4),
(23, 'Dicta dolor quidem totam earum nisi cumque odio modi suscipit sit incidunt quaerat quae laboriosam omnis aut et deserunt labore id.', '2022-08-01 21:16:12', NULL, 24, 9),
(24, 'Ut laboriosam et nihil et dolorem voluptas hic tempora eius voluptatem dolorem quasi veritatis quis reiciendis rem dolorem esse minus.', '2022-08-01 21:16:12', NULL, 25, 10),
(25, 'Fuga vero consequatur possimus qui cumque doloremque odit omnis facilis sed quod tenetur sed eveniet consequatur et molestias vel vitae alias quo facilis repellendus.', '2022-08-01 21:16:12', NULL, 19, 1),
(26, 'Non quasi unde est voluptatem dolorum rerum sit natus placeat laborum expedita veritatis sint ut porro tempore at et necessitatibus tenetur.', '2022-08-01 21:16:12', NULL, 19, 5),
(27, 'Quia qui ex accusantium ut quidem sint vero quia perspiciatis quo maxime culpa consectetur repellat eum aliquam sed enim similique aliquid ut voluptatem aliquid exercitationem.', '2022-08-01 21:16:12', NULL, 24, 10),
(28, 'Maiores maxime et a soluta minima distinctio est nesciunt possimus odio omnis sunt sint voluptatem aliquam at id commodi molestiae.', '2022-08-01 21:16:12', NULL, 16, 5),
(29, 'Enim quasi atque necessitatibus alias incidunt quos vitae expedita dicta nobis numquam expedita quia quaerat culpa molestiae nemo explicabo minima autem natus.', '2022-08-01 21:16:12', NULL, 4, 2),
(31, 'Ratione sint voluptate ex quasi repellendus quae autem eum ut ab fugiat voluptas consectetur autem non sed aut voluptatem odit qui consequatur sit id.', '2022-08-01 21:16:12', NULL, 27, 8),
(32, 'Nisi quas aut eos possimus sapiente id explicabo explicabo sunt cumque voluptates modi sed numquam recusandae aliquam autem deserunt eaque.', '2022-08-01 21:16:12', NULL, 5, 7),
(33, 'Eaque quisquam odio et laudantium earum nesciunt qui ipsa recusandae iure illo et tempore eius voluptates perferendis ipsam qui laudantium.', '2022-08-01 21:16:12', NULL, 24, 2),
(34, 'In vel nihil aut quod est quisquam est modi vero commodi fuga quidem incidunt sit soluta quas necessitatibus dolores saepe consectetur ipsum.', '2022-08-01 21:16:12', NULL, 15, 2),
(35, 'Quas modi distinctio quas iste repudiandae libero quas animi harum quo repellendus officiis autem porro velit dignissimos totam itaque doloremque.', '2022-08-01 21:16:12', NULL, 14, 9),
(36, 'Ut quis fugiat maiores corporis officia quaerat voluptatum quae itaque minima dolore dolorum ducimus veniam aut veritatis reiciendis accusamus dolor.', '2022-08-01 21:16:12', NULL, 24, 2),
(38, 'Fugiat repellat in dignissimos facilis deserunt corporis et aspernatur earum itaque facere omnis neque accusamus facere et recusandae consequatur omnis doloremque consequatur.', '2022-08-01 21:16:13', NULL, 17, 5),
(39, 'Praesentium sed aut aspernatur qui sit totam quia aut vero odio officiis eos sed velit veritatis laboriosam dolore modi velit ut iste.', '2022-08-01 21:16:13', NULL, 8, 7),
(40, 'Aperiam a rerum quis et non repellat et voluptatem voluptatem quod sequi explicabo rerum doloribus est eligendi similique unde sit minus.', '2022-08-01 21:16:13', NULL, 18, 2),
(41, 'Et asperiores veniam ea consequatur est rerum nobis sint ex ea modi ut hic culpa magni et qui cupiditate commodi sint.', '2022-08-01 21:16:13', NULL, 20, 3),
(42, 'Ex magnam ipsum beatae dolorem minima et sit quaerat sit facere repudiandae non amet modi eius sed eligendi est inventore doloribus in doloribus.', '2022-08-01 21:16:13', NULL, 19, 8),
(43, 'Mollitia maxime ut cumque odit est voluptates aperiam voluptatem voluptas quis repudiandae odit ut ut et beatae harum earum repellat.', '2022-08-01 21:16:13', NULL, 9, 3),
(44, 'Soluta enim quo voluptates impedit vitae provident consequuntur dolorum quos architecto aliquam et commodi voluptatum possimus expedita quos libero voluptate ab nobis ut quia.', '2022-08-01 21:16:13', NULL, 23, 5),
(45, 'Et exercitationem ut dignissimos assumenda voluptatem accusantium est eum hic rerum distinctio voluptate enim non id non fugit autem harum.', '2022-08-01 21:16:13', NULL, 25, 1),
(46, 'Voluptatem ut odio totam qui earum sapiente et aliquid consequatur omnis enim exercitationem dolore qui quia commodi ut expedita est nostrum autem voluptate vero est.', '2022-08-01 21:16:13', NULL, 19, 8),
(47, 'Laborum omnis earum quia omnis quibusdam nobis ratione voluptas eos fugit consequatur assumenda ut esse odio dolorem sed odio mollitia architecto.', '2022-08-01 21:16:13', NULL, 9, 5),
(48, 'Ratione nihil aut sit alias nisi qui dolor est repudiandae nihil sed minus numquam sapiente soluta rerum qui amet quisquam vero.', '2022-08-01 21:16:13', NULL, 19, 3),
(49, 'Quis alias saepe itaque sint eius est libero asperiores consectetur saepe tempore dolorum commodi dolorem omnis temporibus consectetur nihil temporibus neque.', '2022-08-01 21:16:13', NULL, 3, 10),
(50, 'Modi qui repellendus omnis voluptatem dolor est inventore et consequatur nemo reprehenderit eius sit harum eum et quaerat excepturi officiis velit at ad.', '2022-08-01 21:16:13', NULL, 9, 1),
(51, 'Voluptate at totam perspiciatis in nulla molestiae veniam corporis animi aut at consequuntur ut consequatur dolor dolorum quo earum expedita voluptates in quidem omnis.', '2022-08-01 21:16:13', NULL, 9, 6),
(52, 'Cum error debitis in delectus et aut aut occaecati rerum ea quia cum deserunt repudiandae dolore aut illum neque at recusandae exercitationem dolorum.', '2022-08-01 21:16:13', NULL, 26, 2),
(53, 'Alias eius est quis ut blanditiis nobis eos omnis nihil beatae natus numquam cumque ipsum sunt maiores sed ad quia ullam voluptas maiores eligendi.', '2022-08-01 21:16:13', NULL, 6, 6),
(54, 'Amet repellendus voluptatum doloribus suscipit blanditiis nesciunt quos non ad qui praesentium quae vero earum doloremque exercitationem assumenda maiores provident voluptatum sunt velit illum.', '2022-08-01 21:16:13', NULL, 19, 10),
(55, 'Quisquam autem minima dolor quo facere consectetur voluptatem dolore asperiores est et quis quisquam cum tempore vitae voluptatem officia sed sed rerum.', '2022-08-01 21:16:14', NULL, 26, 9),
(56, 'Temporibus sed et doloribus aliquam fugiat autem eveniet non enim itaque architecto voluptate voluptatum eum eaque molestias pariatur vel velit illum fuga vero tempore ut.', '2022-08-01 21:16:14', NULL, 3, 8),
(57, 'Sed voluptatem aut voluptatum eos enim dolorem quia adipisci molestiae natus minima alias omnis ut consectetur earum sit voluptatem unde voluptate.', '2022-08-01 21:16:14', NULL, 14, 5),
(58, 'Quibusdam dolorum adipisci dolorem numquam voluptatem laborum ex quod velit nulla harum ea asperiores incidunt expedita quo ex cumque cum.', '2022-08-01 21:16:14', NULL, 18, 5),
(59, 'Minus consequatur eaque dolores nesciunt omnis laudantium eum omnis sit deleniti autem labore sint veritatis et cumque voluptas doloribus dolores.', '2022-08-01 21:16:14', NULL, 8, 3),
(60, 'Voluptates unde quod dolores sit aut atque similique voluptatem id cumque ullam aut assumenda omnis qui aliquam reiciendis ea aperiam sit tempora.', '2022-08-01 21:16:14', NULL, 14, 6),
(61, 'Quod et quia molestias atque iusto est nulla voluptas ut dolorem voluptatem ipsum blanditiis at quasi odit illo consequatur est ut modi incidunt.', '2022-08-01 21:16:14', NULL, 27, 8),
(62, 'Esse neque maiores aut corrupti nemo nihil deleniti eius assumenda fugiat nesciunt doloremque dolor numquam placeat maiores accusamus reprehenderit provident.', '2022-08-01 21:16:14', NULL, 18, 8),
(63, 'Sunt molestiae vitae dolor est dolores reiciendis ut quo temporibus sequi quaerat laudantium velit voluptatem quae quibusdam aspernatur qui placeat deleniti.', '2022-08-01 21:16:14', NULL, 17, 3),
(64, 'Iure omnis distinctio libero voluptatum rerum voluptas fugit molestiae libero inventore aperiam esse voluptas itaque illum ipsa dolores vitae et.', '2022-08-01 21:16:14', NULL, 14, 4),
(65, 'Unde est debitis illum suscipit et ab ut culpa amet accusamus cumque hic nesciunt maxime voluptas rerum non eligendi illo quis incidunt dolor ex dolore.', '2022-08-01 21:16:14', NULL, 17, 1),
(66, 'Possimus et ullam et nulla consectetur modi et nulla ipsum id suscipit voluptatibus dolor dolores atque quasi eos magnam error.', '2022-08-01 21:16:14', NULL, 30, 2),
(67, 'Non perferendis facilis et sit et ducimus nihil in cupiditate et incidunt sit soluta itaque et eaque recusandae tempora harum occaecati qui eius culpa.', '2022-08-01 21:16:14', NULL, 28, 4),
(68, 'Autem minima nemo perferendis iure voluptas non esse voluptate esse quia id voluptas dolorem nostrum enim sequi sequi aut quo tenetur.', '2022-08-01 21:16:14', NULL, NULL, 10),
(69, 'Voluptas sapiente provident culpa molestiae laborum soluta voluptatem quia aperiam rerum id veniam tenetur iste illo est molestiae architecto unde mollitia corporis quia non quae.', '2022-08-01 21:16:14', NULL, 28, 2),
(70, 'Perspiciatis consequatur consequatur voluptas laudantium nam rerum sint ut omnis minus praesentium alias ipsum velit qui alias voluptatem qui nesciunt.', '2022-08-01 21:16:14', NULL, 29, 5),
(71, 'Sint laudantium possimus quia dolore rerum nihil voluptatum non dolorem et enim quam non consequatur officia distinctio ut itaque aut tenetur recusandae nulla.', '2022-08-01 21:16:14', NULL, 4, 3),
(72, 'Dicta id dolore asperiores cupiditate et delectus cum distinctio corrupti eaque atque quia est enim autem aut eligendi ipsam asperiores quo nemo reprehenderit reprehenderit.', '2022-08-01 21:16:14', NULL, 21, 3),
(73, 'Et et enim repellendus et libero consequatur rerum vel natus eos voluptatem reprehenderit enim voluptatem aperiam sequi ratione eius beatae nihil qui omnis eum et.', '2022-08-01 21:16:14', NULL, 9, 10),
(74, 'Vero saepe exercitationem quae doloremque suscipit sapiente dicta harum animi rerum natus rerum sapiente quod aliquid enim accusamus omnis pariatur numquam natus rerum suscipit voluptatem.', '2022-08-01 21:16:14', NULL, 30, 8),
(75, 'Fugiat temporibus necessitatibus et vero maxime similique odio aliquid aut nihil provident molestias libero aliquid nemo repudiandae mollitia assumenda id ratione et sit sequi.', '2022-08-01 21:16:15', NULL, 4, 4),
(76, 'Reiciendis voluptatibus similique rem fuga tempore omnis quaerat quas qui aliquam dolorem cum accusantium molestiae quibusdam dignissimos aut sit velit reprehenderit omnis omnis.', '2022-08-01 21:16:15', NULL, 22, 7),
(77, 'Eos facere dolore autem quaerat veritatis et iusto reprehenderit laborum illo rerum aut explicabo dolorem doloremque voluptas nihil suscipit et omnis.', '2022-08-01 21:16:15', NULL, 18, 2),
(78, 'Quia magni est qui ut illum sint sequi est ipsam et saepe consequuntur quisquam doloremque repudiandae dicta aperiam quae voluptates odit et quae occaecati.', '2022-08-01 21:16:15', NULL, 28, 5),
(79, 'Eos doloribus unde ullam explicabo sit nisi cumque qui officia pariatur quisquam incidunt tempore omnis aliquam dolorem voluptatem magnam rerum ipsum.', '2022-08-01 21:16:15', NULL, 29, 8),
(80, 'Sit aut vel itaque tenetur consequatur impedit incidunt aliquam sed aut eos voluptas non beatae alias numquam sit eligendi nihil beatae.', '2022-08-01 21:16:15', NULL, 5, 9),
(81, 'Reprehenderit commodi mollitia soluta error veritatis velit ab enim qui velit unde commodi dolor ullam aspernatur adipisci dolores eum quo incidunt porro qui.', '2022-08-01 21:16:15', NULL, 17, 3),
(82, 'Aperiam voluptatem similique est pariatur voluptatem optio est quasi sapiente dolorem neque minus voluptatibus accusamus veniam minus commodi dolorem molestias ducimus minus iure.', '2022-08-01 21:16:15', NULL, 30, 4),
(83, 'Ducimus quo eaque enim odio fuga rem accusamus est dolorum vel non sed perferendis omnis ex aliquid debitis nisi eveniet et aliquam nisi.', '2022-08-01 21:16:15', NULL, 15, 2),
(84, 'Earum velit deserunt ad atque reiciendis tenetur error aut consequatur itaque qui temporibus expedita ipsum odit ullam aut in omnis eaque eveniet libero placeat pariatur.', '2022-08-01 21:16:15', NULL, 13, 7),
(85, 'Quos minima id enim officia autem iure molestiae sunt ea vel delectus soluta autem modi accusantium quos sequi blanditiis iusto sit deleniti et sed.', '2022-08-01 21:16:15', NULL, 6, 6),
(86, 'Qui temporibus ratione nulla nisi hic fugiat impedit quidem voluptatem est dicta dolores facilis exercitationem sapiente cumque nesciunt et ipsa in sed sequi consectetur optio.', '2022-08-01 21:16:15', NULL, 23, 10),
(87, 'Qui error asperiores dolor nemo quia fugiat non exercitationem soluta expedita autem nesciunt in amet laboriosam dolores voluptatem est aut corrupti.', '2022-08-01 21:16:15', NULL, 29, 2),
(88, 'Quod non culpa ut beatae eos officiis eos reprehenderit quisquam at aut consequuntur in numquam sit rerum magni est ut rem omnis facere.', '2022-08-01 21:16:15', NULL, 30, 1),
(89, 'Blanditiis consequatur molestiae molestiae sed molestias corrupti vel ab vero voluptatem in commodi beatae non accusantium repudiandae sit dignissimos illo.', '2022-08-01 21:16:15', NULL, 12, 1),
(90, 'Labore eaque quidem numquam incidunt aut rem officia dolorem quia doloribus qui et vero officiis neque voluptas pariatur beatae omnis repellat velit.', '2022-08-01 21:16:15', NULL, 28, 3),
(91, 'Perferendis qui expedita quo excepturi voluptas voluptatem expedita quos itaque autem ut maiores omnis eligendi inventore ipsum rem quasi sed sunt et.', '2022-08-01 21:16:15', NULL, 29, 9),
(92, 'Aspernatur neque quod illum architecto neque cupiditate quas repellat sequi qui ipsum qui numquam qui ea reiciendis consequatur quia dolorum vel quasi ex.', '2022-08-01 21:16:15', NULL, 30, 1),
(93, 'Iste neque nostrum quasi velit deleniti ducimus aperiam est incidunt minima voluptatem tempora ipsam temporibus ut temporibus eaque dolorem quae.', '2022-08-01 21:16:16', NULL, 11, 3),
(94, 'Quam et eos ab officia esse laborum ratione aut vel rerum fuga iure laborum corporis eligendi at consectetur et nemo ipsam earum qui.', '2022-08-01 21:16:16', NULL, 3, 6),
(95, 'Quo laudantium eos et culpa culpa tenetur qui veniam aut aut itaque quia sunt ea minus eius nisi id labore omnis dolor in occaecati qui.', '2022-08-01 21:16:16', NULL, 18, 6),
(96, 'Odit ut ipsa hic ab exercitationem nulla illum ea dolor similique cumque beatae vitae perspiciatis laudantium pariatur velit sed eos dolore beatae quas.', '2022-08-01 21:16:16', NULL, 14, 1),
(97, 'Libero cupiditate doloribus consequatur rerum dolor magni quia excepturi qui et minus asperiores quo sunt omnis excepturi provident quia sit qui.', '2022-08-01 21:16:16', NULL, 10, 7),
(98, 'Earum sed qui quia quia numquam accusamus cumque ea perspiciatis quia qui temporibus aliquam a harum et dignissimos officia sapiente.', '2022-08-01 21:16:16', NULL, NULL, 8),
(99, 'Amet tempore repellendus vel ut quae ea iste et molestiae facere eius provident soluta rerum accusantium impedit blanditiis repudiandae qui ab.', '2022-08-01 21:16:16', NULL, 20, 6),
(100, 'In aut itaque ullam ut similique debitis est officia adipisci nisi pariatur corporis nobis expedita enim autem fugiat minima tempore doloremque.', '2022-08-01 21:16:16', NULL, 10, 7),
(101, 'Ea qui sed error illum dignissimos sint dolores placeat similique qui molestias non voluptatem cumque aliquid eaque explicabo sequi iste deleniti.', '2022-08-02 11:05:35', NULL, 3, 10),
(102, 'Ea vel beatae aperiam ea adipisci consequatur quis et dolorem commodi ipsa impedit in ducimus consectetur quasi quas qui aut iure consequuntur repellat.', '2022-08-02 11:05:35', NULL, 3, 4),
(103, 'Repellendus necessitatibus et excepturi et rem et molestiae culpa placeat voluptatem et aliquam quas sunt ullam voluptatibus modi non voluptas architecto fugit nemo repellendus.', '2022-08-02 11:05:35', NULL, 14, 4),
(104, 'Autem esse aut modi quo et voluptas magnam voluptas et et maiores vel tempora laudantium optio autem quae blanditiis animi.', '2022-08-02 11:05:35', NULL, 28, 7),
(105, 'Vel consequuntur quibusdam tempore optio vero excepturi ullam quo omnis incidunt ipsam suscipit aut sit eum hic magnam eligendi itaque iusto et.', '2022-08-02 11:05:36', NULL, 5, 5),
(106, 'Velit aut tempora modi voluptatem repudiandae est labore consequatur enim ut voluptatem eum aspernatur qui consequatur qui quam doloremque consequatur modi fugiat.', '2022-08-02 11:05:36', NULL, 21, 6),
(107, 'Alias cumque mollitia vero est aut voluptatem excepturi maiores autem et voluptates voluptatem dolor est quibusdam eum dolorem ducimus totam.', '2022-08-02 11:05:36', NULL, 25, 3),
(108, 'Qui molestiae eius nulla quidem asperiores velit voluptatum odit autem incidunt sit voluptas sed repellendus enim voluptas quam beatae alias quasi sed veniam odit et.', '2022-08-02 11:05:36', NULL, 22, 10),
(109, 'Voluptatem fuga qui neque minus sint aspernatur eum in perspiciatis dignissimos reiciendis et tempore et eos natus possimus et numquam aspernatur qui.', '2022-08-02 11:05:36', NULL, 5, 8),
(110, 'Ut aut et laboriosam vel nesciunt et distinctio ad dolores dolor provident qui eaque aut est natus blanditiis voluptas inventore dolor est.', '2022-08-02 11:05:36', NULL, 30, 1),
(111, 'Voluptatum nemo corrupti optio nobis qui laudantium velit ipsa dignissimos iste similique in distinctio tempora illum itaque atque sunt non ea quam et.', '2022-08-02 11:05:36', NULL, 25, 4),
(112, 'Deserunt harum odio omnis alias consequatur dignissimos quae tenetur est quidem quibusdam sapiente quo distinctio deserunt rerum consequatur reiciendis quae animi ea maxime.', '2022-08-02 11:05:36', NULL, 20, 4),
(113, 'Ut quia tempore distinctio porro ut illum omnis laudantium incidunt sapiente et sed id dolores quia nemo maiores molestiae et voluptatem.', '2022-08-02 11:05:36', NULL, 6, 7),
(114, 'Dolores et quas molestiae nulla explicabo quos corporis voluptate aliquid voluptates ea ducimus ullam necessitatibus tenetur sunt aut praesentium enim.', '2022-08-02 11:05:36', NULL, 16, 4),
(115, 'Quae odio explicabo minus nesciunt deleniti veritatis quia hic eveniet ab necessitatibus quasi accusantium tempore voluptas dolorem velit et voluptas.', '2022-08-02 11:05:36', NULL, 29, 3),
(116, 'Doloremque ut ut omnis repellendus vel nisi rem atque vel numquam aut veritatis unde et sint cupiditate voluptas recusandae vitae assumenda eum facere culpa sit.', '2022-08-02 11:05:36', NULL, 21, 3),
(118, 'Labore et quam debitis distinctio consequatur perspiciatis vel magni ea dolorem nisi nihil ea et rerum quo aperiam eaque animi ut quos accusantium sint.', '2022-08-02 11:05:36', NULL, 12, 6),
(119, 'Consequatur consequatur voluptas qui eum quae sit esse vitae voluptas saepe ut est consequatur occaecati qui et pariatur nemo pariatur.', '2022-08-02 11:05:36', NULL, 26, 6),
(120, 'Necessitatibus rerum et ut eius voluptate et quaerat aut id ullam placeat consequuntur sunt repellendus et ut enim ipsam maxime et.', '2022-08-02 11:05:36', NULL, 27, 1),
(121, 'Molestias exercitationem est est voluptas sunt enim voluptas quam cupiditate aut voluptatem commodi repudiandae aut ad autem sit sint ut impedit.', '2022-08-02 11:05:36', NULL, 24, 3),
(122, 'Asperiores dolor ab et similique pariatur rerum adipisci neque repellendus libero atque aut enim eligendi est quis quo nesciunt dolor omnis omnis.', '2022-08-02 11:05:36', NULL, 4, 7),
(123, 'Numquam omnis consectetur sint eligendi est culpa asperiores adipisci dolores unde consequatur numquam minus nihil sit fugit nesciunt dolor assumenda repellat non id sunt.', '2022-08-02 11:05:36', NULL, 17, 7),
(124, 'Et dolores ipsam doloribus quibusdam nisi harum qui cum quo ut voluptatem voluptates error rerum perferendis ducimus esse est dolores repellendus sunt.', '2022-08-02 11:05:37', NULL, 21, 7),
(125, 'Modi deserunt cupiditate nihil et et necessitatibus qui et voluptatum minus voluptatem ea ratione deleniti esse maxime enim harum ullam.', '2022-08-02 11:05:37', NULL, 28, 2),
(127, 'Blanditiis sunt molestiae voluptate necessitatibus accusantium tempora unde sunt quia tenetur et perferendis assumenda dolor magnam neque eligendi voluptatibus laudantium.', '2022-08-02 11:05:37', NULL, 9, 4),
(128, 'Adipisci et vel aut voluptatem aut vitae ut necessitatibus perspiciatis est voluptatem et voluptatem dolores molestias optio ab qui necessitatibus.', '2022-08-02 11:05:37', NULL, 4, 4),
(129, 'Quis sequi quo dolores explicabo dolorem saepe qui rerum corporis in dolores qui sint corporis exercitationem non quam dolorem saepe ea.', '2022-08-02 11:05:37', NULL, 8, 4),
(130, 'Voluptatem ipsa veniam aperiam ad est praesentium fugit facilis dicta et dolores libero molestias tenetur quis rerum est eos reprehenderit quia optio at adipisci labore.', '2022-08-02 11:05:37', NULL, NULL, 4),
(131, 'Voluptatem facilis suscipit tempore harum eveniet temporibus cupiditate et doloremque voluptatem minima magnam iste debitis quo ea enim doloribus officia deserunt quam aut excepturi perferendis.', '2022-08-02 11:05:37', NULL, 30, 3),
(132, 'Quae aspernatur et corporis ea et animi hic natus ab necessitatibus sed modi odit natus incidunt impedit autem id aut molestiae ex optio.', '2022-08-02 11:05:37', NULL, 28, 4),
(133, 'Ducimus minus quod est esse vero exercitationem voluptas iure delectus sed in sapiente accusamus ut expedita atque incidunt veritatis harum laborum ut quam fugit.', '2022-08-02 11:05:37', NULL, 14, 10),
(135, 'Occaecati sunt ea quis quaerat non est qui officia illum et eveniet rerum perspiciatis repellat velit pariatur quis dolor earum dolore veniam.', '2022-08-02 11:05:37', NULL, 13, 6),
(136, 'Dolor dicta recusandae illum ut accusantium voluptatem fugit ullam corrupti excepturi accusamus aut rerum fuga et cupiditate sit porro molestias labore quia et et porro.', '2022-08-02 11:05:37', NULL, 21, 2),
(137, 'In quisquam quia alias numquam molestiae quis aperiam magnam dicta asperiores voluptas veritatis in et non veritatis consequatur aliquam quo.', '2022-08-02 11:05:37', NULL, 25, 2),
(138, 'Molestiae facere id et sed adipisci quos aut et architecto vitae soluta inventore asperiores ut necessitatibus sapiente voluptate omnis labore molestias similique eligendi.', '2022-08-02 11:05:37', NULL, 19, 5),
(139, 'Non rerum nobis sequi ab quia nobis autem in inventore velit doloremque doloremque quasi voluptatem qui doloremque esse sint eligendi explicabo.', '2022-08-02 11:05:37', NULL, NULL, 10),
(140, 'Voluptates molestiae voluptates delectus expedita a omnis esse facere doloribus fugiat enim molestias numquam sed illum consequatur facilis aut dolorem labore enim.', '2022-08-02 11:05:37', NULL, 11, 9),
(141, 'Perspiciatis qui delectus eligendi eaque omnis occaecati doloribus molestiae autem alias quis porro molestiae exercitationem voluptatem molestiae qui sit dolores labore quia rerum est ullam.', '2022-08-02 11:05:37', NULL, 26, 9),
(142, 'Voluptate quo aut reprehenderit magni explicabo laboriosam quia sed enim optio harum et quia ut aliquam omnis consequatur qui qui asperiores rem non nisi eos.', '2022-08-02 11:05:37', NULL, 10, 1),
(143, 'Dolor quam ex maiores reiciendis vel sequi placeat qui cum nihil qui rem eos fuga est est est quia aut qui.', '2022-08-02 11:05:37', NULL, 13, 1),
(144, 'Illum aliquam et in quis eveniet illo eveniet incidunt sunt vitae rerum tempora quas tempore sed a sed beatae quas beatae et ab sunt sed.', '2022-08-02 11:05:37', NULL, 10, 1),
(145, 'Aut labore voluptatem nulla excepturi blanditiis consequuntur soluta odit magnam laborum vel beatae maiores eveniet rem enim vel et in dolorem iusto.', '2022-08-02 11:05:38', NULL, 21, 8),
(146, 'Quis sit nulla quos facere ut eius nihil aut et nemo enim sequi et quo eos rerum ipsum tempore eos deserunt tempora.', '2022-08-02 11:05:38', NULL, 5, 10),
(147, 'Maxime est consequatur est sunt nesciunt quos ut dolorum quos aliquid vel in delectus saepe non eius repellat quia optio adipisci distinctio officia est non.', '2022-08-02 11:05:38', NULL, 15, 9),
(148, 'Nemo provident magnam praesentium magni voluptate neque eos ut harum qui iusto aut alias incidunt sit ducimus quibusdam dolorem sint itaque voluptatem dicta eius.', '2022-08-02 11:05:38', NULL, NULL, 10),
(149, 'Officia maxime reprehenderit consequatur eius sed quod tenetur sit error et quia et in consectetur qui blanditiis deserunt nulla corrupti et.', '2022-08-02 11:05:38', NULL, 20, 2),
(150, 'Mollitia mollitia sit cum incidunt iusto laudantium velit velit similique in harum consequatur aut in sed vero et quo ullam debitis consequuntur.', '2022-08-02 11:05:38', NULL, 29, 10),
(151, 'Tempore eos soluta ullam consequatur est facere laudantium sequi qui ab non sunt ipsum quasi sint ratione voluptatibus enim consequatur laborum.', '2022-08-02 11:05:38', NULL, 18, 6),
(152, 'Maxime velit et incidunt dolor dolorem eum labore at nam sapiente optio minima dolorem consectetur voluptatem aut autem quas officia sed.', '2022-08-02 11:05:38', NULL, 24, 8),
(153, 'Sequi saepe cum fugiat aliquam recusandae soluta esse eius in eveniet error id et numquam ut dolorem voluptatum sapiente tempore.', '2022-08-02 11:05:38', NULL, 18, 8),
(154, 'Aliquid omnis tempore corrupti illum voluptatem aspernatur perferendis et et at tempora quasi qui nihil sint perspiciatis provident ut velit id suscipit accusamus est.', '2022-08-02 11:05:38', NULL, 12, 8),
(155, 'Asperiores praesentium eum nisi quibusdam cum dolorum inventore incidunt architecto excepturi consequatur praesentium aliquid quia et non rerum quia sint dicta ut.', '2022-08-02 11:05:38', NULL, 23, 9),
(156, 'Et commodi pariatur assumenda dolore dolorem animi vitae voluptatum quas veniam velit voluptatem deleniti mollitia rerum alias tenetur ad magnam ad.', '2022-08-02 11:05:38', NULL, 15, 4),
(157, 'Quo perspiciatis quibusdam incidunt quos reprehenderit fuga possimus laboriosam alias beatae reiciendis ut maiores delectus et eligendi recusandae aliquid explicabo pariatur amet harum voluptatem.', '2022-08-02 11:05:38', NULL, 27, 8),
(158, 'Ipsam quas in sint commodi et reprehenderit inventore necessitatibus libero unde quis quis quas enim quo quibusdam illum corrupti voluptatibus.', '2022-08-02 11:05:38', NULL, 26, 9),
(159, 'Velit voluptas tenetur fugiat consequatur necessitatibus quasi impedit voluptas aut magni et est illum beatae cumque beatae dolor eaque vero sed ea id.', '2022-08-02 11:05:38', NULL, 16, 2),
(160, 'Et dolorum neque nisi deleniti laudantium voluptas dolorem id aliquam alias quia dolor repudiandae nam sed ut debitis quae facilis.', '2022-08-02 11:05:38', NULL, 4, 10),
(161, 'Sunt libero voluptas voluptas dolorem quibusdam ex impedit quam vel animi deserunt voluptates consequatur sint qui qui eum optio error pariatur at voluptatem.', '2022-08-02 11:05:38', NULL, 13, 4),
(162, 'Temporibus qui debitis alias nemo minus explicabo assumenda quibusdam voluptas nesciunt placeat est molestiae in voluptates vitae minus ut fugiat labore et.', '2022-08-02 11:05:38', NULL, NULL, 3),
(163, 'Aut dolores eveniet quae incidunt voluptas sint ut ducimus assumenda doloremque omnis nemo qui voluptatum porro et aliquam veritatis nobis.', '2022-08-02 11:05:39', NULL, 23, 8),
(164, 'Debitis tenetur delectus amet voluptatem sit nam ut a itaque in sunt dolor culpa optio ea ut suscipit vero in laborum quod et rerum.', '2022-08-02 11:05:39', NULL, 4, 3),
(165, 'Ipsum et cum cum sequi odio fugit quae perferendis dolorem impedit et cum voluptates asperiores sunt suscipit modi beatae voluptatem distinctio amet sit.', '2022-08-02 11:05:39', NULL, 25, 7),
(166, 'Harum ipsum recusandae debitis molestiae aperiam aliquid est veritatis ad et nobis autem reprehenderit consectetur alias similique officia blanditiis rerum consequatur dolor.', '2022-08-02 11:05:39', NULL, 21, 8),
(167, 'Rerum sunt rerum enim maxime veritatis sequi consequatur numquam dolorem dolorum natus in repudiandae ut corrupti quos aut ex et asperiores.', '2022-08-02 11:05:39', NULL, 4, 3),
(168, 'Non veniam error corporis similique est quaerat rerum iste impedit facere impedit saepe tempora soluta commodi facilis facere esse qui quam molestiae esse ut ea.', '2022-08-02 11:05:39', NULL, 8, 4),
(169, 'Eius facere sit fugit qui repudiandae beatae et ipsum quis laboriosam ipsa et temporibus autem mollitia ut dolorem officiis aliquam accusantium.', '2022-08-02 11:05:39', NULL, 15, 8),
(170, 'Reiciendis similique eveniet dolorem omnis qui ut voluptatem pariatur sint et optio et sed unde a illo omnis dignissimos pariatur iusto perspiciatis aut dolores veniam.', '2022-08-02 11:05:39', NULL, 9, 1),
(171, 'Exercitationem officia numquam blanditiis et dolores molestiae quae aut iste iste dolorum nemo aut ut sed nisi nihil omnis nisi voluptatem sed sapiente reiciendis vel.', '2022-08-02 11:05:39', NULL, 17, 6),
(172, 'Et consequuntur at tempore aliquid est molestiae quos in illo et rerum enim totam consequatur et qui doloribus odio sint ducimus sit adipisci itaque.', '2022-08-02 11:05:39', NULL, 28, 8),
(173, 'Reiciendis nisi non omnis et porro ut beatae et tenetur ut ullam dignissimos quia inventore quis repellat est consequuntur eos voluptates.', '2022-08-02 11:05:39', NULL, 21, 6),
(174, 'Minima quod et totam laborum corporis esse dolore atque vero temporibus consequatur soluta ipsam laudantium inventore nostrum quia aliquid assumenda et.', '2022-08-02 11:05:39', NULL, 25, 2),
(175, 'Magni numquam quis eligendi in ipsum delectus dignissimos recusandae nam recusandae perspiciatis ipsam dicta repudiandae consequuntur odio quos voluptatem saepe maiores et aut.', '2022-08-02 11:05:39', NULL, 14, 4),
(176, 'Dolore laborum explicabo sunt rerum qui non aut aut modi enim vel cumque quam itaque sequi doloribus facilis magni laborum ut possimus ipsa.', '2022-08-02 11:05:39', NULL, 6, 2),
(177, 'Inventore deleniti in quia dolorem dignissimos sit corrupti non modi enim soluta et non id quis ex ut et fugiat amet quis.', '2022-08-02 11:05:39', NULL, 3, 7),
(178, 'Iste culpa in iste illo et sed eaque non natus fuga corporis provident ex facere aut iure suscipit nemo porro.', '2022-08-02 11:05:39', NULL, 5, 5),
(179, 'Ratione reprehenderit vel dicta dolorem reiciendis adipisci eligendi nemo possimus error eum sed magni et non repellendus qui et ipsum sint dignissimos.', '2022-08-02 11:05:39', NULL, 20, 1),
(180, 'Ex eos deserunt consequatur est est ad vel itaque molestiae inventore ea non adipisci ea quisquam fugit consequatur illum soluta libero beatae.', '2022-08-02 11:05:39', NULL, 27, 4),
(181, 'Delectus doloribus fugiat eum enim labore ducimus sed et aliquam minus sed asperiores quia rem fugiat tempora adipisci laborum quae nulla ea qui excepturi.', '2022-08-02 11:05:39', NULL, 21, 5),
(182, 'Optio fugit similique est porro earum sit impedit et reiciendis molestiae et dolorem autem autem iure quae porro odio nesciunt eveniet.', '2022-08-02 11:05:39', NULL, 3, 6),
(183, 'Autem non rerum nostrum consequuntur doloribus aliquid rem qui dolores velit et quos est sunt tenetur eligendi sapiente modi officia deserunt.', '2022-08-02 11:05:40', NULL, 6, 7),
(184, 'Perspiciatis eum quidem vel pariatur alias velit ut qui sint tempore numquam odio sed cum deserunt id maxime nemo qui fugiat possimus sed quaerat.', '2022-08-02 11:05:40', NULL, 22, 7),
(185, 'Quo est expedita laborum reiciendis officia consectetur maxime distinctio omnis architecto id voluptatem corrupti nulla quibusdam beatae recusandae est laudantium non.', '2022-08-02 11:05:40', NULL, 21, 10),
(187, 'Consequuntur alias esse neque totam aperiam saepe voluptatibus repudiandae ipsum nihil quos illum aperiam quia iure recusandae repellat illum dolores quo excepturi.', '2022-08-02 11:05:40', NULL, 23, 10),
(188, 'Placeat voluptas ullam perspiciatis molestias rem et nulla incidunt repudiandae ab omnis repellat culpa nihil sint molestias et soluta quia fugiat assumenda.', '2022-08-02 11:05:40', NULL, 26, 9),
(189, 'A sed commodi sunt quo nobis asperiores aut magnam voluptate odit delectus quo reprehenderit ducimus est doloremque enim nihil labore voluptatum et dolor.', '2022-08-02 11:05:40', NULL, 24, 2),
(190, 'Placeat dolore est laboriosam labore vitae itaque veritatis voluptatem fuga sed officia necessitatibus magni distinctio perferendis placeat qui quos fugit consequatur nostrum deserunt earum.', '2022-08-02 11:05:40', NULL, 13, 10),
(191, 'Placeat nisi eaque aspernatur placeat voluptas dolorem id consequuntur excepturi tempora consequuntur voluptatem sed doloremque molestias quia maxime ut fugit.', '2022-08-02 11:05:40', NULL, 24, 5),
(193, 'Quasi perferendis vitae occaecati est vero sed id dolores accusantium earum nobis qui delectus eum dicta sint consequatur aut a.', '2022-08-02 11:05:40', NULL, 19, 6),
(194, 'Molestias ab laboriosam deserunt ratione eos omnis dignissimos aut alias consequatur aut nostrum voluptates enim placeat eius ut asperiores eaque aperiam.', '2022-08-02 11:05:40', NULL, 11, 8),
(195, 'Molestiae incidunt et qui enim voluptatem consequatur minus inventore aut cumque modi sequi dolores atque necessitatibus veniam et totam repellat et libero voluptatem quas voluptate.', '2022-08-02 11:05:40', NULL, 24, 8),
(196, 'Aspernatur et deleniti aspernatur omnis beatae corrupti voluptatum fugiat laborum voluptatibus veniam ipsum magni quasi fugiat cum quos cumque provident rem.', '2022-08-02 11:05:40', NULL, 6, 10),
(197, 'Maxime ut laborum rerum voluptatem qui nostrum soluta reiciendis laudantium et atque veritatis velit molestiae sunt amet eos et aut harum qui qui tempore voluptatem.', '2022-08-02 11:05:40', NULL, 4, 1),
(198, 'Non laudantium eum ut quas ut et accusamus omnis velit tempore natus dolores modi perferendis doloremque eveniet nihil enim voluptatem numquam fuga in ea.', '2022-08-02 11:05:40', NULL, 3, 2),
(199, 'Cum qui commodi aut eos qui facilis non quo quae omnis sunt suscipit consequuntur voluptate culpa nihil ut perspiciatis sunt magni.', '2022-08-02 11:05:40', NULL, 15, 5),
(200, 'Magni rerum facere facilis tempora veniam eius nisi delectus sed impedit nostrum laboriosam cum et nisi velit saepe voluptatem repudiandae ullam ut.', '2022-08-02 11:05:40', NULL, 19, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `identity_card`
--

CREATE TABLE `identity_card` (
  `id` int NOT NULL,
  `expried` datetime DEFAULT NULL,
  `issued` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `identity_card`
--

INSERT INTO `identity_card` (`id`, `expried`, `issued`) VALUES
(1, '2020-08-01 21:15:18', '2024-08-01 21:15:18'),
(2, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(3, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(4, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(5, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(6, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(7, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(8, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(9, '2020-08-01 21:15:19', '2024-08-01 21:15:19'),
(10, '2020-08-01 21:15:19', '2024-08-01 21:15:19');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `image`
--

CREATE TABLE `image` (
  `id` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `image`
--

INSERT INTO `image` (`id`, `created_at`, `url`, `user_id`) VALUES
(1, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 2),
(2, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 6),
(3, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 7),
(4, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 3),
(5, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 3),
(6, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 7),
(7, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 8),
(8, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 7),
(9, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 6),
(10, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 1),
(11, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 9),
(12, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 8),
(13, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 8),
(14, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 2),
(15, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 3),
(16, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 5),
(17, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 2),
(18, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 10),
(19, '2022-08-01 21:15:40', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 5),
(20, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 10),
(21, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 1),
(22, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 5),
(23, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 4),
(24, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 5),
(25, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 6),
(26, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 9),
(27, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 1),
(28, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 1),
(29, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 3),
(30, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 6),
(31, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 10),
(32, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 4),
(33, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 10),
(34, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 5),
(35, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 1),
(36, '2022-08-01 21:15:41', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 9),
(37, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 2),
(38, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 9),
(39, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 3),
(40, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 6),
(41, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 5),
(42, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 2),
(43, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 6),
(44, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 6),
(45, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 2),
(46, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 5),
(47, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 5),
(48, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 10),
(49, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 4),
(50, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 5),
(51, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 8),
(52, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 9),
(53, '2022-08-01 21:15:42', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 8),
(54, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 1),
(55, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 2),
(56, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 1),
(57, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 7),
(58, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 2),
(59, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 3),
(60, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 1),
(61, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 5),
(62, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 3),
(63, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 5),
(64, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 5),
(65, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 8),
(66, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 5),
(67, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 9),
(68, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 4),
(69, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 3),
(70, '2022-08-01 21:15:43', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 3),
(71, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 9),
(72, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 5),
(73, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 8),
(74, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 2),
(75, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 6),
(76, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 5),
(77, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 10),
(78, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 1),
(79, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 10),
(80, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 6),
(81, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 8),
(82, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 9),
(83, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 9),
(84, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 5),
(85, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 10),
(86, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 7),
(87, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 6),
(88, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 2),
(89, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 5),
(90, '2022-08-01 21:15:44', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 8),
(91, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 2),
(92, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 5),
(93, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 3),
(94, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 7),
(95, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 4),
(96, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 10),
(97, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 10),
(98, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 3),
(99, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 6),
(100, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 9),
(101, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 7),
(102, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 10),
(103, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 1),
(104, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 10),
(105, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 2),
(106, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 3),
(107, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 8),
(108, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 4),
(109, '2022-08-01 21:15:45', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 5),
(110, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 2),
(111, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 8),
(112, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 4),
(113, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 4),
(114, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 5),
(115, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 2),
(116, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 9),
(117, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 1),
(118, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 9),
(119, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 4),
(120, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 4),
(121, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 4),
(122, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 1),
(123, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 6),
(124, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 2),
(125, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/1.png', 1),
(126, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 1),
(127, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 5),
(128, '2022-08-01 21:15:46', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 8),
(129, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 6),
(130, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 9),
(131, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 3),
(132, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 3),
(133, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 2),
(134, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 5),
(135, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 8),
(136, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 8),
(137, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 8),
(138, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 9),
(139, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 1),
(140, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 7),
(141, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 1),
(142, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 9),
(143, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 10),
(144, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 9),
(145, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/6.png', 4),
(146, '2022-08-01 21:15:47', 'https://pigment.github.io/fake-logos/logos/medium/color/7.png', 9),
(147, '2022-08-01 21:15:48', 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 4),
(148, '2022-08-01 21:15:48', 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 4),
(149, '2022-08-01 21:15:48', 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 1),
(150, '2022-08-01 21:15:48', 'https://pigment.github.io/fake-logos/logos/medium/color/4.png', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `identity_card_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `avatar`, `email`, `name`, `password`, `identity_card_id`) VALUES
(1, 'https://pigment.github.io/fake-logos/logos/medium/color/9.png', 'cristi.kunde@hotmail.com', 'Arnold Connell', '700', 1),
(2, 'https://pigment.github.io/fake-logos/logos/medium/color/13.png', 'herb.pacocha@hotmail.com', 'Tricia Jenkins', '583', 2),
(3, 'https://pigment.github.io/fake-logos/logos/medium/color/12.png', 'jenniffer.mante@yahoo.com', 'Kerry Olson', '876', 3),
(4, 'https://pigment.github.io/fake-logos/logos/medium/color/3.png', 'renay.douglas@yahoo.com', 'Mrs. Tobias Heathcote', '768', 4),
(5, 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 'whitney.zemlak@gmail.com', 'Mike Swift', '788', 5),
(6, 'https://pigment.github.io/fake-logos/logos/medium/color/11.png', 'evita.rolfson@yahoo.com', 'Mrs. Franklin Mante', '873', 6),
(7, 'https://pigment.github.io/fake-logos/logos/medium/color/5.png', 'nichol.streich@yahoo.com', 'Trinidad Mohr', '824', 7),
(8, 'https://pigment.github.io/fake-logos/logos/medium/color/8.png', 'lorenzo.deckow@hotmail.com', 'Caroll Heller IV', '695', 8),
(9, 'https://pigment.github.io/fake-logos/logos/medium/color/10.png', 'tomasa.sauer@gmail.com', 'Ms. Gigi Wuckert', '289', 9),
(10, 'https://pigment.github.io/fake-logos/logos/medium/color/2.png', 'francis.lowe@yahoo.com', 'Sergio Champlin DVM', '660', 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpxk2jtysqn41oop7lvxcp6dqq` (`user_id`);

--
-- Chỉ mục cho bảng `blog_categories`
--
ALTER TABLE `blog_categories`
  ADD KEY `FKh4dffu5xqmldiyem8ge9wo0d0` (`categories_id`),
  ADD KEY `FKq1kwj39w3nay2x68n33t2iw6l` (`blog_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkap39f76wn135k7ru564fbjb7` (`blog_id`),
  ADD KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`);

--
-- Chỉ mục cho bảng `identity_card`
--
ALTER TABLE `identity_card`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlxnnh0ir05khn8iu9tgwh1yyk` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD KEY `FKlu9rqtsc9psoa2afwayjn5nkt` (`identity_card_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT cho bảng `identity_card`
--
ALTER TABLE `identity_card`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `image`
--
ALTER TABLE `image`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `FKpxk2jtysqn41oop7lvxcp6dqq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `blog_categories`
--
ALTER TABLE `blog_categories`
  ADD CONSTRAINT `FKh4dffu5xqmldiyem8ge9wo0d0` FOREIGN KEY (`categories_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKq1kwj39w3nay2x68n33t2iw6l` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`);

--
-- Các ràng buộc cho bảng `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKkap39f76wn135k7ru564fbjb7` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`);

--
-- Các ràng buộc cho bảng `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FKlxnnh0ir05khn8iu9tgwh1yyk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKlu9rqtsc9psoa2afwayjn5nkt` FOREIGN KEY (`identity_card_id`) REFERENCES `identity_card` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
