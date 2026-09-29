# RichInsights — Native Android V2 UI/UX Blueprint

## 1. Purpose

This document defines the visual and user-experience direction for **RichInsights**, the native Android educational platform.

V2 is a new native experience. V1 is reference material only and must not constrain the new design.

## 2. Product experience

**Product:** RichInsights  
**Tagline:** **Grow. Excel.**

Core feeling: **Clean Competitive**

RichInsights should feel:
- intelligent;
- modern;
- polished;
- energetic;
- trustworthy;
- accessible;
- educational without feeling childish.

The design should support RichInsights as a broader educational platform rather than making the product feel like a quiz app with extra sections.

Avoid:
- excessive gradients;
- visual clutter;
- generic unmodified Material styling;
- overly corporate styling;
- childish game styling;
- unnecessary decoration;
- separate visual identities for individual sections.

## 3. Visual identity

RichInsights uses a **deep navy → intelligent blue → electric cyan → restrained gold** visual hierarchy.

### Brand palette

- **Deep Navy — `#102A43`**
  - primary foundation for strong hierarchy, navigation, headings, and trusted brand surfaces.
- **Intelligent Blue — `#1769E0`**
  - principal action and learning color.
- **Electric Cyan — `#19B5FE`**
  - controlled signature accent for discovery, emphasis, interactive highlights, and selected modern details.
- **Warm Gold — `#F4B942`**
  - restrained achievement accent for points, streaks, milestones, certificates, and similar positive accomplishments.

### Supporting UI palette

- **Background — `#F7F9FC`**
- **Surface — `#FFFFFF`**
- **Primary text — `#172033`**
- **Secondary text — `#667085`**
- **Success — `#22A06B`**
- **Error — `#D64545`**

Semantic green and red are reserved primarily for success, confirmation, incorrect, warning/error, and validation states. Gold is not a general-purpose status color.

The palette should remain controlled. RichInsights should not become a rainbow-style educational app, and individual product sections should not introduce competing brand palettes.

Final implementation tokens must be checked for contrast and accessibility before being treated as production-final.

## 4. Native design foundation

Use **Kotlin + Jetpack Compose** with a reusable RichInsights design system.

The design system will establish:
- typography;
- color roles;
- spacing;
- shapes;
- elevation;
- buttons;
- cards;
- inputs;
- dialogs;
- feedback states;
- loading/error/empty states;
- navigation;
- accessibility behavior;
- reusable product components.

Material 3 may provide underlying primitives, but RichInsights must have its own visual identity and token system.

## 5. Primary navigation

### Compact phones

**Home | Learn | Quiz | Bible | News**

### Profile & Settings

Profile and settings are secondary/global destinations, accessed through the appropriate profile or account action rather than taking a permanent primary-navigation slot.

### Larger screens

Use adaptive navigation appropriate to the available window size. Do not stretch a phone bottom bar across large screens.

Each primary destination should preserve useful navigation state where appropriate.

## 6. Home

Home is the platform entry point.

Potential hierarchy:
1. greeting/personal context;
2. daily challenge;
3. progress/streak;
4. continue learning;
5. featured categories/content;
6. relevant recommendations.

The exact layout will be established through later wireframes and requirements rather than prematurely locking the screen here.

## 7. Learn

Learn is the broader educational area.

It may contain:
- structured learning content;
- lessons;
- topics;
- explanations;
- study experiences;
- learning progress.

The first release should not attempt to build the entire future learning system. The destination exists so RichInsights can grow beyond quizzes cleanly.

## 8. Quiz

Quiz is a major platform experience, not the entire product.

Initial areas:
- General Knowledge;
- Science;
- Africa & Nigeria;
- Current Affairs;
- Bible quizzes.

The UI consumes validated V2 question objects and remains independent of content providers.

### Quiz experience

The quiz interface should clearly communicate:
- progress;
- question;
- answer choices;
- relevant timing;
- score/streak context;
- immediate feedback.

Answer states include:
- default;
- pressed/selected;
- correct;
- incorrect;
- disabled/locked.

Feedback must be immediate, clear, and accessible.

The exact timer and other detailed interaction rules should be validated before being locked into the final design.

## 9. Results and progress

Results should communicate:
- completion;
- score;
- accuracy;
- correct/wrong count;
- points;
- streak;
- progress;
- next action.

Future experiences may add explanations, topic performance, achievements, recommendations, and learning feedback.

## 10. Bible

Bible is a dedicated product area.

Conceptual structure:

    Bible
    ├── Read Bible
    │   ├── Book
    │   ├── Chapter
    │   └── Reader
    ├── Bible Quiz
    └── Future Study

Reader requirements:
- offline reading when properly licensed content is available;
- book/chapter navigation;
- search;
- silent reading by default;
- user-triggered read-aloud;
- play/pause/resume/stop;
- future speed/voice controls.

Read-aloud must never start automatically.

## 11. News

News is a dedicated top-level experience.

It remains architecturally separate from the **Current Affairs** quiz category. News should have its own content and interaction model rather than forcing news content into the quiz system.

Detailed News UX will be designed after its product requirements and content decisions are established.

## 12. Typography and interaction

Typography should provide:
- strong headings;
- highly readable learning and quiz text;
- clear scores and progress;
- comfortable body text;
- consistent hierarchy.

Use normal native Compose rendering. Do not introduce unnecessary text-selection restrictions as a copy-prevention mechanism.

Touch targets must be comfortable, and important meaning must never rely on color alone.

## 13. Responsive and adaptive design

Design for:
- phones;
- larger phones;
- landscape;
- tablets;
- foldables;
- split-screen and changing window sizes.

Do not build a phone-only layout and retrofit larger screens later.

Where useful, larger windows may display multiple related panes instead of simply enlarging a single-column phone layout.

## 14. Connectivity states

RichInsights is **online-first**, not broadly offline-first.

The UI must make connectivity requirements obvious.

### Limited local/offline support

- **Home:** selected basic/cached portions may remain available offline.
- **Profile:** selected cached information such as progress and history may remain visible offline.
- **Learn:** explicitly downloaded content may be available offline.
- **Bible:** properly licensed Bible reading should remain available offline.

### Internet-required

- Quiz;
- News;
- Current Affairs;
- fresh Learn browsing/downloads;
- fresh Home content/recommendations;
- Bible quizzes;
- server-backed Bible study features;
- synchronization and live content.

Design clear states for:
- loading;
- connecting;
- offline;
- connection lost;
- empty;
- temporary failure;
- retry;
- feature unavailable because internet is required;
- ad unavailable;
- unexpected error.

Messages should be short, human-readable, and actionable. Never expose raw provider/API errors.

## 15. Advertising UX

V2 AdMob is a fresh implementation.

Rules:
- ads never cover quiz content or controls;
- quiz functionality must remain usable when an ad fails;
- interstitials belong at appropriate transitions;
- rewarded ads are optional;
- development uses test ads;
- production identifiers/configuration remain separate;
- ad loading and failure states are handled gracefully.

Exact placements are implementation decisions and must be tested rather than copied from V1.

## 16. Premium and billing UX

Future commercial surfaces may include:
- Premium;
- Remove Ads;
- premium content/features;
- purchase and restore states;
- active entitlement state.

Requirements:
- communicate value clearly;
- show price and billing period clearly;
- distinguish subscriptions from one-time products;
- explain entitlements;
- avoid deceptive urgency or aggressive paywalls;
- preserve user context through purchase flows.

Billing is planned for later stages and is not part of the initial UI foundation.

## 17. Accessibility

Requirements:
- sufficient contrast;
- no reliance on color alone;
- meaningful content descriptions where needed;
- comfortable touch targets;
- scalable text and layouts;
- logical focus and navigation semantics;
- accessibility testing across major screens.

Accessibility is a design-system requirement, not a final cleanup task.

## 18. Motion

Motion should:
- confirm interactions;
- clarify transitions;
- communicate progress;
- reinforce meaningful feedback.

Avoid excessive motion during timed quizzes. Animations must remain performant on lower-end devices.

## 19. Reusable component foundation

The design system will eventually provide reusable components such as:
- primary and secondary buttons;
- cards;
- content/category cards;
- answer options;
- progress indicators;
- timers;
- score displays;
- streak indicators;
- dialogs;
- feedback states;
- loading/error/empty states;
- navigation components;
- ad containers;
- premium/entitlement indicators.

Components should be system-level building blocks, not one-off screen decorations.

## 20. Design process

**RESEARCH → WIREFRAME → DESIGN SYSTEM → HIGH-FIDELITY SCREENS → IMPLEMENT → BUILD → INSTALL → TEST → FIX → CHECKPOINT**

Do not design every future screen before its requirements are known.

## 21. Android application identity

- **Product:** RichInsights
- **Android application/package identity:** `com.ricven.richinsights`
- **Repository:** `ricvenlimited/richinsights-android`

## 22. Current V2 status

- RichInsights is the V2 product identity.
- Native Android is the target implementation.
- The product is being designed as a broader educational platform, not a quiz-only app.
- Primary navigation is **Home / Learn / Quiz / Bible / News**.
- Profile & Settings is secondary/global.
- The visual direction is **deep navy → intelligent blue → electric cyan → restrained gold**, supported by neutral surfaces and semantic green/red.
- Adaptive navigation and responsive layouts are required.
- Bible is a major product section.
- News is separate from Current Affairs.
- Quiz UI is provider-independent.
- AdMob and billing are fresh V2 work, not copied V1 implementations.
- High-fidelity implementation follows the native foundation and domain/content contracts.